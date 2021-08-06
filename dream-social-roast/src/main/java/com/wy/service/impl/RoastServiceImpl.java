package com.wy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.wy.model.Roast;
import com.wy.repository.RoastRepository;
import com.wy.service.RoastService;
import com.wy.utils.IdWorker;

@Service
public class RoastServiceImpl implements RoastService {

	@Autowired
	private RoastRepository roastRepository;

	@Autowired
	private IdWorker idWorker;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Roast> findAll() {
		return roastRepository.findAll();
	}

	public Roast findById(String id) {
		return roastRepository.findById(id).get();
	}

	public void save(Roast roast) {
		roast.set_id(idWorker.nextId() + "");
		// 初始化数据完善
		roast.setPublishtime(new Date());// 发布日期
		roast.setVisits(0);// 浏览量
		roast.setShare(0);// 分享数
		roast.setThumbup(0);// 点赞数
		roast.setComment(0);// 回复数
		roast.setState("1");// 状态
		// 判断当前吐槽是否有父节点
		if (roast.getParentid() != null && !"".equals(roast.getParentid())) {
			// 给父节点吐槽的回复数加一
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(roast.getParentid()));
			Update update = new Update();
			update.inc("comment", 1);
			mongoTemplate.updateFirst(query, update, "roast");
		}
		roastRepository.save(roast);
	}

	public void update(Roast roast) {
		roastRepository.save(roast);
	}

	public void deleteById(String id) {
		roastRepository.deleteById(id);
	}

	public Page<Roast> pageQuery(String parentid, int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return roastRepository.findByParentid(parentid, pageable);
	}

	// db.roast.update({_id:"2"},{$inc:{visits:NumberInt(1)}} )
	public void addthumbup(String id) {
		// 方式一
		// Roast roast = roastRepository.findById(id).get();
		// roast.setThumbup(roast.getThumbup()+1);
		// roastRepository.save(roast);

		// 存储过程和存储函数的优势
		// 存储过程相当于把业务逻辑写到数据库端
		// 加入java端有一个业务逻辑需要十次数据库操作,
		// 那么我们正常来说就需要链接数据库十次
		// 链接数据库频繁就意味要牺牲效率
		// 如果用存储过程把业务逻辑写到数据库端
		// 只需要链接一次数据库就可以完成十步操作
		// 默认情况下存储过程无法并发,但是可以优化
		// 而且存储过程和存储函数使用的编程语言是pl/sql是面向过程的,维护起来特别麻烦
		// 方式二
		// 封装的是查询条件
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		// 封装修改的数据内容
		Update update = new Update();
		update.inc("thumbup", 1);
		mongoTemplate.updateFirst(query, update, "roast");
	}
}
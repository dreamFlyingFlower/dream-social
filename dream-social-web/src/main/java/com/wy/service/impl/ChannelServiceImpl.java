package com.wy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.wy.model.Channel;
import com.wy.repository.ChannelRepository;
import com.wy.service.ChannelService;
import com.wy.utils.IdWorker;

/**
 * 频道业务实现类
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:46:23
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Service
public class ChannelServiceImpl implements ChannelService {

	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public List<Channel> findAll() {
		return channelRepository.findAll();
	}

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Channel> findSearch(Map<String, Object> whereMap, int page, int size) {
		Specification<Channel> specification = createSpecification(whereMap);
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		return channelRepository.findAll(specification, pageRequest);
	}

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<Channel> findSearch(Map<String, Object> whereMap) {
		Specification<Channel> specification = createSpecification(whereMap);
		return channelRepository.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	public Channel findById(String id) {
		return channelRepository.findById(id).get();
	}

	/**
	 * 增加
	 * 
	 * @param channel
	 */
	public void add(Channel channel) {
		channel.setId(idWorker.nextId() + "");
		channelRepository.save(channel);
	}

	/**
	 * 修改
	 * 
	 * @param channel
	 */
	public void update(Channel channel) {
		channelRepository.save(channel);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(String id) {
		channelRepository.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * 
	 * @param searchMap
	 * @return
	 */
	private Specification<Channel> createSpecification(Map<String, Object> searchMap) {

		return new Specification<Channel>() {

			private static final long serialVersionUID = -4085516502846526549L;

			@Override
			public Predicate toPredicate(Root<Channel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				// ID
				if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
					predicateList
							.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
				}
				// 频道名称
				if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
					predicateList.add(
							cb.like(root.get("name").as(String.class), "%" + (String) searchMap.get("name") + "%"));
				}
				// 状态
				if (searchMap.get("state") != null && !"".equals(searchMap.get("state"))) {
					predicateList.add(
							cb.like(root.get("state").as(String.class), "%" + (String) searchMap.get("state") + "%"));
				}
				return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};
	}
}
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

import com.wy.model.Column;
import com.wy.repository.ColumnRepository;
import com.wy.service.ColumnService;
import com.wy.utils.IdWorker;

/**
 * 栏目业务实现类
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:48:20
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Service
public class ColumnServiceImpl implements ColumnService {

	@Autowired
	private ColumnRepository columnRepository;

	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public List<Column> findAll() {
		return columnRepository.findAll();
	}

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Column> findSearch(Map<String, Object> whereMap, int page, int size) {
		Specification<Column> specification = createSpecification(whereMap);
		PageRequest pageRequest = PageRequest.of(page - 1, size);
		return columnRepository.findAll(specification, pageRequest);
	}

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<Column> findSearch(Map<String, Object> whereMap) {
		Specification<Column> specification = createSpecification(whereMap);
		return columnRepository.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	public Column findById(String id) {
		return columnRepository.findById(id).get();
	}

	/**
	 * 增加
	 * 
	 * @param column
	 */
	public void add(Column column) {
		column.setId(idWorker.nextId() + "");
		columnRepository.save(column);
	}

	/**
	 * 修改
	 * 
	 * @param column
	 */
	public void update(Column column) {
		columnRepository.save(column);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(String id) {
		columnRepository.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * 
	 * @param searchMap
	 * @return
	 */
	private Specification<Column> createSpecification(Map<String, Object> searchMap) {

		return new Specification<Column>() {

			private static final long serialVersionUID = 6348470230991905724L;

			@Override
			public Predicate toPredicate(Root<Column> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				// ID
				if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
					predicateList
							.add(cb.like(root.get("id").as(String.class), "%" + (String) searchMap.get("id") + "%"));
				}
				// 专栏名称
				if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
					predicateList.add(
							cb.like(root.get("name").as(String.class), "%" + (String) searchMap.get("name") + "%"));
				}
				// 专栏简介
				if (searchMap.get("summary") != null && !"".equals(searchMap.get("summary"))) {
					predicateList.add(cb.like(root.get("summary").as(String.class),
							"%" + (String) searchMap.get("summary") + "%"));
				}
				// 用户ID
				if (searchMap.get("userid") != null && !"".equals(searchMap.get("userid"))) {
					predicateList.add(
							cb.like(root.get("userid").as(String.class), "%" + (String) searchMap.get("userid") + "%"));
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
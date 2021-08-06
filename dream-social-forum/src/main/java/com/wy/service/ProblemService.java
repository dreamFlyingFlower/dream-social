package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Problem;

public interface ProblemService {

	Page<Problem> newlist(String labelid, int page, int size);

	Page<Problem> hotlist(String labelid, int page, int size);

	Page<Problem> waitlist(String labelid, int page, int size);

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Problem> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Problem> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Problem> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Problem findById(String id);

	/**
	 * 增加
	 * 
	 * @param problem
	 */
	void add(Problem problem);

	/**
	 * 修改
	 * 
	 * @param problem
	 */
	void update(Problem problem);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
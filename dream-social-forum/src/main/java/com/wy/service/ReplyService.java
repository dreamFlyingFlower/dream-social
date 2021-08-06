package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Reply;

public interface ReplyService {

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Reply> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Reply> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Reply> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Reply findById(String id);

	/**
	 * 增加
	 * 
	 * @param reply
	 */
	void add(Reply reply);

	/**
	 * 修改
	 * 
	 * @param reply
	 */
	void update(Reply reply);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Column;

/**
 * 栏目业务接口
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:43:15
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface ColumnService {

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Column> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Column> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Column> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Column findById(String id);

	/**
	 * 增加
	 * 
	 * @param column
	 */
	void add(Column column);

	/**
	 * 修改
	 * 
	 * @param column
	 */
	void update(Column column);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
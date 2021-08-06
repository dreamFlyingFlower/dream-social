package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Gathering;

/**
 * 
 * 
 * @author 飞花梦影
 * @date 2021-08-03 08:53:47
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface GatheringService {

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Gathering> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Gathering> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Gathering> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 * @Cacheable 添加缓存 value属性表示缓存整体唯一标识,key属性标识缓存键值对中的key
	 */
	Gathering findById(String id);

	/**
	 * 增加
	 * 
	 * @param gathering
	 */
	void add(Gathering gathering);

	/**
	 * 修改
	 * 
	 * @param gathering
	 */
	void update(Gathering gathering);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
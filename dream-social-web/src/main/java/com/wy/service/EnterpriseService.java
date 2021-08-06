package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Enterprise;

/**
 * 企业接口
 * 
 * @author 飞花梦影
 * @date 2021-08-03 08:30:13
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface EnterpriseService {

	List<Enterprise> hotList();

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Enterprise> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Enterprise> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Enterprise> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Enterprise findById(String id);

	/**
	 * 增加
	 * 
	 * @param enterprise
	 */
	void add(Enterprise enterprise);

	/**
	 * 修改
	 * 
	 * @param enterprise
	 */
	void update(Enterprise enterprise);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
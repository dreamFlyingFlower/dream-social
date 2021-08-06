package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Recruit;

/**
 * 招聘业务接口
 * 
 * @author 飞花梦影
 * @date 2021-08-03 08:30:24
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface RecruitService {

	List<Recruit> findTop6ByStateOrderByCreatetime();

	List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc();

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Recruit> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Recruit> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Recruit> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Recruit findById(String id);

	/**
	 * 增加
	 * 
	 * @param recruit
	 */
	void add(Recruit recruit);

	/**
	 * 修改
	 * 
	 * @param recruit
	 */
	void update(Recruit recruit);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
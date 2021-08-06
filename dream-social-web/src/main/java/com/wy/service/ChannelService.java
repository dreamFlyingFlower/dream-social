package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Channel;

/**
 * 频道业务接口
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:40:08
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface ChannelService {

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Channel> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Channel> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Channel> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Channel findById(String id);

	/**
	 * 增加
	 * 
	 * @param channel
	 */
	void add(Channel channel);

	/**
	 * 修改
	 * 
	 * @param channel
	 */
	void update(Channel channel);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
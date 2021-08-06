package com.wy.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.base.service.BaseService;
import com.wy.model.User;

public interface UserService extends BaseService<User, Long> {

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<User> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param user
	 * @return
	 */
	Page<User> findSearchPage(User user);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<User> findSearch(User user);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	User findById(String id);

	/**
	 * 增加
	 * 
	 * @param user
	 */
	void add(User user);

	/**
	 * 修改
	 * 
	 * @param user
	 */
	void update(User user);

	/**
	 * 删除 必须有admin角色才能删除
	 * 
	 * @param id
	 */
	void deleteById(String id);

	void sendSms(String mobile);

	User login(String mobile, String password);

	void updatefanscountandfollowcount(int x, String userid, String friendid);
}
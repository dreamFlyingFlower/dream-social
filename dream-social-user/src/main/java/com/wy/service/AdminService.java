package com.wy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.base.service.BaseService;
import com.wy.model.Admin;

import java.util.List;

/**
 * 管理员业务层实现类
 * 
 * @author 飞花梦影
 * @date 2021-07-30 13:41:28
 * @git {@link https://github.com/dreamFlyingFlower }
 */
public interface AdminService extends BaseService<Admin, Long> {

	Admin login(Admin admin);

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Admin> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param user 查询参数
	 * @return
	 */
	Page<Admin> findSearchPage(Admin admin);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Admin> findSearch(Admin admin);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Admin findById(Long id);

	/**
	 * 增加
	 * 
	 * @param admin
	 */
	void add(Admin admin);

	/**
	 * 修改
	 * 
	 * @param admin
	 */
	void update(Admin admin);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
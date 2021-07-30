package com.wy.mapper;

import com.wy.base.BaseMapper;
import com.wy.model.Admin;

/**
 * 管理员数据层
 * 
 * @author 飞花梦影
 * @date 2021-07-30 16:48:51
 * @git {@link https://github.com/dreamFlyingFlower }
 */
public interface AdminMapper extends BaseMapper<Admin, Long> {

	public Admin findByLoginname(String loginname);
}
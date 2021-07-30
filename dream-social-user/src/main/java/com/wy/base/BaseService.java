package com.wy.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wy.result.Result;

/**
 * 通用Service业务接口
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:17:39
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface BaseService<T, ID extends Serializable> extends IService<T> {

	/**
	 * 根据表中主键查询单条数据详情
	 * 
	 * @param id 主键编号
	 * @return 单实体类结果集
	 */
	Object info(ID id);

	/**
	 * 根据上级编号递归获得表中树形结构数据
	 * 
	 * @param id 上级编号
	 * @param self 是否查询本级数据,true获取,false直接获取下级,默认false
	 * @param params 其他基本类型参数
	 * @return 树形结果集
	 */
	// List<T> getTree(ID id, Boolean self, Map<String, Object> params);

	/**
	 * 根据条件将数据库中符合的数据一次全部查出来
	 * 
	 * @param params 其他基本类型参数
	 * @return 主键编号和数据的对应集合
	 */
	// Map<ID, List<T>> getLeaf(Map<String, Object> params);

	/**
	 * 查询分页/不分页列表,根据实体类非空数据做相等条件判断
	 * 
	 * @param t 实体类对象
	 * @return 分页/不分页列表数据
	 */
	Result<List<T>> getEntitys(T t);

	/**
	 * 单表数据导出功能,默认数据来源于getEntitys方法
	 * 
	 * @param t
	 *        实体类参数,若beginCreatetime,endCreatetime,beginUpdatetime,endUpdatetime有值,则会和createtime,updatetime字段比较
	 * @param request 请求,主要是传入需要导出的excel名称
	 * @param response 响应
	 */
	void getExport(T t, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 该方法参数以及返回值都是map类型
	 * 
	 * @param params 分页时需要传pageIndex和pageSize,可传特殊类型参数,需要特殊处理,就是一个map,可能后期会做些其他处理
	 * @return 分页/不分页list
	 */
	Result<List<Map<String, Object>>> getLists(Map<String, Object> params);

	/**
	 * 判断表中是否有重复的值,只查询非null字段,需要每个xml中都手写countByEntity方法
	 * 
	 * @param t 需要查询的值
	 * @return true代表有重复值,false代表无重复值
	 */
	boolean hasValue(T t);

	List<Map<String, Object>> getTree(ID id, Boolean self, Map<String, Object> params);
}
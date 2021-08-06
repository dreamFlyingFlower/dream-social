package com.wy.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wy.base.model.Tree;
import com.wy.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通用Service业务接口
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:17:39
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface BaseService<T, ID extends Serializable> extends IService<T> {

	/**
	 * 单条数据新增
	 * 
	 * @param t 新增数据
	 * @return 新增后的数据
	 */
	Object create(T t);

	/**
	 * 批量数据新增,只会插入实体对象中的非空值
	 * 
	 * @param ts 需要新增的数据列表
	 * @return 新增结果.默认返回boolean,true->新增成功,false->新增失败
	 */
	Object creates(List<T> ts);

	/**
	 * 单条数据修改
	 * 
	 * @param t 需要修改的数据
	 * @return 修改后的数据
	 */
	Object edit(T t);

	/**
	 * 批量数据修改,只修改实体对象中的非空值
	 * 
	 * @param ts 需要修改的数据列表
	 * @return 修改结果.默认返回boolean,true->修改成功,false->修改失败
	 */
	Object edits(List<T> ts);

	

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
	 * 获得指定字段的最大值,只能是数字类型字段
	 * 
	 * @param column Java属性字段,会自动转下划线
	 * @return 最大值
	 */
	Long getMax(String column);

	/**
	 * 根据上级编号递归获得表中树形结构数据
	 * 
	 * @param id 父级编号
	 * @param self 是否查询本级数据:true->查询,false->默认,获取下级
	 * @param params 其他基本类型参数
	 * @return 树形结果集
	 */
	List<Tree> getTree(ID id, Boolean self, Map<String, Object> params);

	/**
	 * 判断表中是否有重复的值,只查询非空且值相等的字段
	 * 
	 * @param t 需要查询的实体类
	 * @return true->有重复值,false->无重复值
	 */
	boolean hasValue(T t);

	/**
	 * 根据表中主键查询单条数据详情
	 * 
	 * @param id 主键编号
	 * @return 单实体类结果集
	 */
	Object info(ID id);

	/**
	 * 根据主键列表编号获得数据详情列表
	 * 
	 * @param ids 主编编号列表
	 * @return 详情列表.默认返回实体类对象列表
	 */
	Object infos(List<ID> ids);

	/**
	 * 根据主键删除单条数据
	 * 
	 * @param id 主键编号
	 * @return 删除结果.默认返回boolean,true->删除成功,false->删除失败
	 */
	Object remove(ID id);

	/**
	 * 根据主键删除多条数据
	 * 
	 * @param ids 主键编号列表
	 * @return 删除结果.默认返回boolean,true->删除成功,false->删除失败
	 */
	Object removes(List<ID> ids);
}
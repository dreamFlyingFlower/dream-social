package com.wy.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wy.result.Result;

/**
 * 通用Service业务实现类
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:20:33
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public abstract class AbstractService<M extends BaseMapper<T>, T, ID extends Serializable>
		extends ServiceImpl<BaseMapper<T>, T> implements BaseService<T, Serializable> {

	@Override
	public Object info(Serializable id) {
		return baseMapper.selectById(id);
	}

	/**
	 * 分页/不分页查询,参数为非空字段的等值查询,除createtime和updatetime字段会根据传参的值进行比较
	 * 
	 * @param t 实体类,若beginCreatetime,endCreatetime,beginUpdatetime,endUpdatetime有值,
	 *        则会和createtime,updatetime字段比较
	 * @return 分页/不分页结果集
	 */
	@Override
	public Result<List<T>> getEntitys(T t) {
		if (t instanceof Pager) {
			Pager pager = (Pager) t;
			if (pager.hasPager()) {
				Page<T> selectPage = baseMapper.selectPage(new Page<>(pager.getPageIndex(), pager.getPageSize()),
						new QueryWrapper<>(t));
				return Result.page(selectPage.getRecords(), (int) selectPage.getCurrent(), (int) selectPage.getSize(),
						selectPage.getTotal());
			}
		}
		return Result.ok(baseMapper.selectList(new QueryWrapper<>(t)));
	}

	@Override
	public void getExport(T t, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public Result<List<Map<String, Object>>> getLists(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasValue(T t) {
		return baseMapper.selectCount(new QueryWrapper<>(t)) > 0;
	}

	@Override
	public List<Map<String, Object>> getTree(Serializable id, Boolean self, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
}
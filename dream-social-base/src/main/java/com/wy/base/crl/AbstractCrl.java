package com.wy.base.crl;

import com.wy.collection.ListTool;
import com.wy.result.Result;
import com.wy.valid.ValidCreates;
import com.wy.valid.ValidEdits;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * 通用增删改API
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:13:29
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Api(tags = "通用控制层增删改API")
public abstract class AbstractCrl<T, ID extends Serializable> extends QueryCrl<T, ID> {

	/**
	 * 通用处理参数校验
	 *
	 * @param bindingResult 参数绑定校验
	 * @return null->校验通过,非null->校验不结果
	 */
	protected Result<?> handlerBindingResult(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			FieldError error = bindingResult.getFieldError();
			assert error != null;
			return Result.error(error.getField() + error.getDefaultMessage());
		}
		return null;
	}

	/**
	 * 通用单条数据新增,null数据不新增,暂时不考虑权限,每个权限不一样,需要重新设计
	 *
	 * @param t 需要新增的数据
	 * @param bindingResult 字段校验
	 * @return 新增是否成功
	 */
	@ApiOperation("单条数据新增")
	@PostMapping("create")
	public Result<?> create(@RequestBody @Validated(ValidCreates.class) T t, BindingResult bindingResult) {
		Result<?> result = handlerBindingResult(bindingResult);
		return Objects.isNull(result) ? Result.ok(baseService.create(t)) : result;
	}

	/**
	 * 批量新增,不检查任何有效性
	 * 
	 * @param ts 批量新增的数据
	 * @return 结果集
	 */
	@ApiOperation("批量数据新增,不检查任何有效性")
	@PostMapping("creates")
	public Result<?> creates(@RequestBody List<T> ts) {
		return baseService.saveBatch(ts) ? Result.ok("新增成功") : Result.error("新增失败");
	}

	/**
	 * 根据主键删除表中单条数据
	 * 
	 * @param id 主键编号
	 * @return 结果
	 */
	@ApiOperation("根据主键删除表中单条数据")
	@GetMapping("remove/{id}")
	public Result<?> remove(@PathVariable ID id) {
		return baseService.removeById(id) ? Result.ok("删除成功") : Result.error("删除失败");
	}

	/**
	 * 根据主键批量删除表中数据
	 * 
	 * @param ids 主键编号集合
	 * @return 结果
	 */
	@ApiOperation("根据主键批量删除表中数据")
	@PostMapping("removes")
	public Result<?> removes(@RequestBody List<ID> ids) {
		if (ListTool.isEmpty(ids)) {
			return Result.error("集合数据为空");
		}
		return Result.ok(baseService.removeByIds(ids));
	}

	/**
	 * 根据主键编号更新数据,只更新非空数据
	 * 
	 * @param t 需要更新的数据
	 * @param bindingResult 参数验证结果
	 * @return 结果
	 */
	@ApiOperation("根据主键编号更新数据,只更新非空数据")
	@PostMapping("edit")
	public Result<?> edit(@RequestBody @Validated(ValidEdits.class) T t, BindingResult bindingResult) {
		Result<?> result = handlerBindingResult(bindingResult);
		if (Objects.isNull(result)) {
			Object res = baseService.edit(t);
			return Objects.nonNull(res) ? Result.ok(res) : Result.error("更新失败");
		}
		return result;
	}
}
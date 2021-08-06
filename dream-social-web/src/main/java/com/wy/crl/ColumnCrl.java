package com.wy.crl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wy.model.Column;
import com.wy.result.Result;
import com.wy.service.ColumnService;

@RestController
@CrossOrigin
@RequestMapping("/column")
public class ColumnCrl {

	@Autowired
	private ColumnService columnService;

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@GetMapping
	public Result<?> findAll() {
		return Result.ok(columnService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@GetMapping("/{id}")
	public Result<?> findById(@PathVariable String id) {
		return Result.ok(columnService.findById(id));
	}

	/**
	 * 分页+多条件查询
	 * 
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@PostMapping("/search/{page}/{size}")
	public Result<?> findSearch(@RequestBody Map<String, Object> searchMap, @PathVariable int page,
			@PathVariable int size) {
		Page<Column> pageList = columnService.findSearch(searchMap, page, size);
		return Result.page(pageList.getContent(), pageList.getNumber(), pageList.getSize(),
				pageList.getTotalElements());
	}

	/**
	 * 根据条件查询
	 * 
	 * @param searchMap
	 * @return
	 */
	@PostMapping("/search")
	public Result<?> findSearch(@RequestBody Map<String, Object> searchMap) {
		return Result.ok(columnService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * 
	 * @param column
	 */
	@PostMapping
	public Result<?> add(@RequestBody Column column) {
		columnService.add(column);
		return Result.ok();
	}

	/**
	 * 修改
	 * 
	 * @param column
	 */
	@PutMapping("/{id}")
	public Result<?> update(@RequestBody Column column, @PathVariable String id) {
		column.setId(id);
		columnService.update(column);
		return Result.ok();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public Result<?> delete(@PathVariable String id) {
		columnService.deleteById(id);
		return Result.ok();
	}
}
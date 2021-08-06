package com.wy.crl;

import java.util.List;
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

import com.wy.model.Recruit;
import com.wy.result.Result;
import com.wy.service.RecruitService;

@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitCrl {

	@Autowired
	private RecruitService recruitService;

	@GetMapping("/search/recommend")
	public Result<?> recommend() {
		List<Recruit> list = recruitService.findTop6ByStateOrderByCreatetime();
		return Result.ok(list);
	}

	@GetMapping("/search/newlist")
	public Result<?> newlist() {
		List<Recruit> list = recruitService.findTop6ByStateNotOrderByCreatetimeDesc();
		return Result.ok(list);
	}

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@GetMapping
	public Result<?> findAll() {
		return Result.ok(recruitService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@GetMapping("/{id}")
	public Result<?> findById(@PathVariable String id) {
		return Result.ok(recruitService.findById(id));
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
		Page<Recruit> pageList = recruitService.findSearch(searchMap, page, size);
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
		return Result.ok(recruitService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * 
	 * @param recruit
	 */
	@PostMapping
	public Result<?> add(@RequestBody Recruit recruit) {
		recruitService.add(recruit);
		return Result.ok();
	}

	/**
	 * 修改
	 * 
	 * @param recruit
	 */
	@PutMapping("/{id}")
	public Result<?> update(@RequestBody Recruit recruit, @PathVariable String id) {
		recruit.setId(id);
		recruitService.update(recruit);
		return Result.ok();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public Result<?> delete(@PathVariable String id) {
		recruitService.deleteById(id);
		return Result.ok();
	}
}
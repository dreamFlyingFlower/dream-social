package com.wy.crl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.wy.client.BaseClient;
import com.wy.enums.TipEnum;
import com.wy.lang.StrTool;
import com.wy.model.Problem;
import com.wy.result.Result;
import com.wy.service.ProblemService;

@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemCrl {

	@Autowired
	private ProblemService problemService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private BaseClient baseClient;

	@GetMapping("/label/{labelId}")
	public Result<?> findByLabelId(@PathVariable String labelId) {
		return baseClient.findById(labelId);
	}

	@GetMapping("/newlist/{labelid}/{page}/{size}")
	public Result<?> newList(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
		Page<Problem> pageData = problemService.newlist(labelid, page, size);
		return Result.page(pageData.getContent(), pageData.getNumber(), pageData.getSize(),
				pageData.getTotalElements());
	}

	@GetMapping("/hotlist/{labelid}/{page}/{size}")
	public Result<?> hotlist(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
		Page<Problem> pageData = problemService.hotlist(labelid, page, size);
		return Result.page(pageData.getContent(), pageData.getNumber(), pageData.getSize(),
				pageData.getTotalElements());
	}

	@GetMapping("/waitlist/{labelid}/{page}/{size}")
	public Result<?> waitlist(@PathVariable String labelid, @PathVariable int page, @PathVariable int size) {
		Page<Problem> pageData = problemService.waitlist(labelid, page, size);
		return Result.page(pageData.getContent(), pageData.getNumber(), pageData.getSize(),
				pageData.getTotalElements());
	}

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@GetMapping
	public Result<?> findAll() {
		return Result.ok(problemService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@GetMapping("/{id}")
	public Result<?> findById(@PathVariable String id) {
		return Result.ok(problemService.findById(id));
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
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
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
		return Result.ok(problemService.findSearch(searchMap));
	}

	/**
	 * 增加
	 * 
	 * @param problem
	 */
	@PostMapping
	public Result<?> add(@RequestBody Problem problem) {
		String token = (String) request.getAttribute("claims_user");
		if (StrTool.isBlank(token)) {
			return Result.error(TipEnum.TIP_ROLE_PERMISSION_DENIED);
		}
		problemService.add(problem);
		return Result.ok();
	}

	/**
	 * 修改
	 * 
	 * @param problem
	 */
	@PutMapping("/{id}")
	public Result<?> update(@RequestBody Problem problem, @PathVariable String id) {
		problem.setId(id);
		problemService.update(problem);
		return Result.ok();
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public Result<?> delete(@PathVariable String id) {
		problemService.deleteById(id);
		return Result.ok();
	}
}
package com.wy.crl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wy.model.Roast;
import com.wy.result.Result;
import com.wy.service.RoastService;

@RestController
@RequestMapping("/roast")
@CrossOrigin
public class RoastCrl {

	@Autowired
	private RoastService roastService;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@GetMapping
	public Result<?> findAll() {
		return Result.ok(roastService.findAll());
	}

	@GetMapping("/{roastId}")
	public Result<?> findById(@PathVariable String roastId) {
		return Result.ok(roastService.findById(roastId));
	}

	@PostMapping
	public Result<?> save(@RequestBody Roast roast) {
		roastService.save(roast);
		return Result.ok();
	}

	@PutMapping("/{roastId}")
	public Result<?> update(@PathVariable String roastId, @RequestBody Roast roast) {
		roast.set_id(roastId);
		roastService.update(roast);
		return Result.ok();
	}

	@DeleteMapping("/{roastId}")
	public Result<?> delete(@PathVariable String roastId) {
		roastService.deleteById(roastId);
		return Result.ok();
	}

	@GetMapping("/comment/{parentid}/{page}/{size}")
	public Result<?> comment(@PathVariable String parentid, @PathVariable int page, @PathVariable int size) {
		Page<Roast> pageData = roastService.pageQuery(parentid, page, size);
		return Result.page(pageData.getContent(), pageData.getNumber(), pageData.getSize(),
				pageData.getTotalElements());
	}

	@PutMapping("/thumbup/{roastId}")
	public Result<?> addthumbup(@PathVariable String roastId, String userId) {
		// 先判断该用户是否已经点赞了
		if (redisTemplate.opsForValue().get("roast_" + userId + "_" + roastId) != null) {
			return Result.error("不能重复点赞");
		}
		roastService.addthumbup(roastId);
		redisTemplate.opsForValue().set("roast_" + userId + "_" + roastId, 1);
		return Result.ok();
	}
}
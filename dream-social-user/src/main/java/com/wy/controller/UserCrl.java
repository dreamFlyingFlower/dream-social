package com.wy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.enums.TipEnum;
import com.wy.model.User;
import com.wy.result.Result;
import com.wy.service.UserService;
import com.wy.services.JwtServices;

/**
 * 控制器层
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserCrl {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private JwtServices jwtUtil;

	/**
	 * 更新好友粉丝数和用户关注数
	 * 
	 * @return
	 */
	@PutMapping("/{userid}/{friendid}/{x}")
	public void updatefanscountandfollowcount(@PathVariable String userid, @PathVariable String friendid,
			@PathVariable int x) {
		userService.updatefanscountandfollowcount(x, userid, friendid);
	}

	@PostMapping("/login")
	public Result<?> login(@RequestBody User user) {
		user = userService.login(user.getMobile(), user.getPassword());
		if (user == null) {
			return Result.error(TipEnum.TIP_USER_NOT_EXIST);
		}
		String token = jwtUtil.createJwt(user.getUserId(), user.getMobile(), "user");
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("roles", "user");
		return Result.ok("登录成功");
	}

	/**
	 * 发送短信验证码
	 */
	@PostMapping("/sendsms/{mobile}")
	public Result<?> sendSms(@PathVariable String mobile) {
		userService.sendSms(mobile);
		return Result.ok();
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	@PostMapping(value = "/register/{code}")
	public Result<?> regist(@PathVariable String code, @RequestBody User user) {
		// 得到缓存中的验证码
		String checkcodeRedis = (String) redisTemplate.opsForValue().get("checkcode_" + user.getMobile());
		if (checkcodeRedis.isEmpty()) {
			return Result.error("请先获取手机验证码");
		}
		if (!checkcodeRedis.equals(code)) {
			return Result.error("请输入正确的验证码");
		}
		userService.add(user);
		return Result.ok();
	}

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	@GetMapping("findAll")
	public Result<?> findAll() {
		return Result.ok(userService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return
	 */
	@GetMapping("/{id}")
	public Result<?> findById(@PathVariable String id) {
		return Result.ok(userService.findById(id));
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
	public Result<?> findSearchPage(@RequestBody User user) {
		Page<User> searchPage = userService.findSearchPage(user);
		return Result.page(searchPage.getRecords(), (int) searchPage.getCurrent(), (int) searchPage.getSize(),
				searchPage.getTotal());
	}

	/**
	 * 根据条件查询
	 * 
	 * @param searchMap
	 * @return
	 */
	@PostMapping("/search")
	public Result<?> findSearch(@RequestBody User user) {
		return Result.ok(userService.findSearch(user));
	}

	/**
	 * 增加
	 * 
	 * @param user
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody User user) {
		userService.add(user);
		return Result.ok();
	}

	/**
	 * 修改
	 * 
	 * @param user
	 */
	@PutMapping("/{id}")
	public Result<?> update(@RequestBody User user, @PathVariable Long id) {
		user.setUserId(id);
		userService.update(user);
		return Result.ok();
	}

	/**
	 * 删除 必须有admin角色才能删除
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public Result<?> delete(@PathVariable String id) {
		userService.deleteById(id);
		return Result.ok();
	}
}
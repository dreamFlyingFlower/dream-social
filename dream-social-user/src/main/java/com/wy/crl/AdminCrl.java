package com.wy.crl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.enums.TipEnum;
import com.wy.model.Admin;
import com.wy.result.Result;
import com.wy.service.AdminService;
import com.wy.services.JwtServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理员API
 *
 * @author 飞花梦影
 * @date 2021-07-31 08:54:56
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Api(tags = "管理员API")
@RestController
@CrossOrigin
@RequestMapping("admin")
public class AdminCrl {

	@Autowired
	private AdminService adminService;

	@Autowired
	private JwtServices jwtUtil;

	@PostMapping("/login")
	public Result<?> login(@RequestBody Admin admin) {
		Admin adminLogin = adminService.login(admin);
		if (adminLogin == null) {
			return Result.error(TipEnum.TIP_LOGIN_FAIL);
		}
		// 使得前后端可以通话的操作。采用JWT来实现。
		// 生成令牌
		String token = jwtUtil.createJwt(adminLogin.getAdminId(), adminLogin.getLoginname(), "admin");
		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("role", "admin");
		return Result.ok(map);
	}

	/**
	 * 查询全部数据
	 * 
	 * @return 全部数据
	 */
	@GetMapping("findAll")
	public Result<?> findAll() {
		return Result.ok(adminService.findAll());
	}

	/**
	 * 根据ID查询
	 * 
	 * @param id ID
	 * @return 详情数据
	 */
	@GetMapping("/{id}")
	public Result<?> findById(@PathVariable Long id) {
		return Result.ok(adminService.findById(id));
	}

	/**
	 * 分页+多条件查询
	 * 
	 * @param admin 查询条件
	 * @return 分页结果
	 */
	@PostMapping("/searchPage")
	public Result<?> findSearchPage(@RequestBody Admin admin) {
		Page<Admin> pageList = adminService.findSearchPage(admin);
		return Result.page(pageList.getRecords(), (int) pageList.getCurrent(), (int) pageList.getSize(),
				pageList.getTotal());
	}

	/**
	 * 根据条件查询
	 *
	 * @param admin 查询条件
	 * @return 结果
	 */
	@PostMapping("/search")
	public Result<?> findSearch(@RequestBody Admin admin) {
		return Result.ok(adminService.findSearch(admin));
	}

	/**
	 * 增加
	 * 
	 * @param admin 参数
	 * @return 结果
	 */
	@PostMapping
	public Result<?> add(@RequestBody Admin admin) {
		adminService.add(admin);
		return Result.ok();
	}

	/**
	 * 修改
	 *
	 * @param admin 参数
	 * @return 结果
	 */
	@PutMapping("/{id}")
	public Result<?> update(@RequestBody Admin admin, @PathVariable Long id) {
		admin.setAdminId(id);
		adminService.update(admin);
		return Result.ok();
	}

	/**
	 * 删除
	 * 
	 * @param id 管理员编号
	 * @return 结果
	 */
	@DeleteMapping("/{id}")
	public Result<?> delete(@ApiParam("管理员编号") @PathVariable String id) {
		adminService.deleteById(id);
		return Result.ok();
	}
}
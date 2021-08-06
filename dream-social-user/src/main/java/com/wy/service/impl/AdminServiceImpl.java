package com.wy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.base.service.AbstractService;
import com.wy.mapper.AdminMapper;
import com.wy.model.Admin;
import com.wy.service.AdminService;
import com.wy.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员业务实现类
 *
 * @author 飞花梦影
 * @date 2021-07-30 17:17:40
 * @git {@link https://github.com/dreamFlyingFlower }
 */
@Service
public class AdminServiceImpl extends AbstractService<AdminMapper, Admin, Long> implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private IdWorker idWorker;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Admin login(Admin admin) {
		// 先根据用户名查询对象
		Admin adminLogin = adminMapper.findByLoginname(admin.getLoginname());
		// 然后拿数据库中的密码和用户输入的密码匹配是否相同
		if (adminLogin != null && encoder.matches(admin.getPassword(), adminLogin.getPassword())) {
			// 保证数据库中的对象中的密码和用户输入的密码是一致的,登录成功
			return adminLogin;
		}
		// 登录失败
		return null;
	}

	/**
	 * 查询全部列表
	 *
	 * @return
	 */
	public List<Admin> findAll() {
		return this.lambdaQuery().list();
	}

	/**
	 * 条件查询+分页
	 *
	 * @param user 查询参数
	 * @return
	 */
	public Page<Admin> findSearchPage(Admin admin) {
		if (admin.hasPager()) {
			return adminMapper.selectPage(new Page<>(admin.getPageIndex(), admin.getPageSize()),
					new QueryWrapper<>(admin));
		}
		return adminMapper.selectPage(new Page<>(-1, 1), new QueryWrapper<>(admin));
	}

	/**
	 * 条件查询
	 *
	 * @param whereMap
	 * @return
	 */
	public List<Admin> findSearch(Admin admin) {
		return adminMapper.selectList(new QueryWrapper<>(admin));
	}

	/**
	 * 根据ID查询实体
	 *
	 * @param id
	 * @return
	 */
	public Admin findById(Long id) {
		return this.getById(id);
	}

	/**
	 * 增加
	 *
	 * @param admin
	 */
	public void add(Admin admin) {
		admin.setAdminId(idWorker.nextId());
		// 密码加密
		admin.setPassword(encoder.encode(admin.getPassword()));
		adminMapper.insert(admin);
	}

	/**
	 * 修改
	 *
	 * @param admin
	 */
	public void update(Admin admin) {
		adminMapper.updateById(admin);
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	public void deleteById(String id) {
		adminMapper.deleteById(id);
	}
}
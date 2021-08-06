package com.wy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.mapper.UserMapper;
import com.wy.model.User;
import com.wy.service.UserService;
import com.wy.base.service.AbstractService;
import com.wy.collection.ListTool;
import com.wy.result.ResultException;
import com.wy.util.RandomTool;
import com.wy.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户业务实现类
 *
 * @author 飞花梦影
 * @date 2021-07-30 17:14:35
 * @git {@link https://github.com/dreamFlyingFlower }
 */
@Service
public class UserServiceImpl extends AbstractService<UserMapper, User, Long> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private IdWorker idWorker;

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private HttpServletRequest request;

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	public List<User> findAll() {
		return this.lambdaQuery().list();
	}

	/**
	 * 条件查询+分页
	 * 
	 * @param user
	 * @return
	 */
	public Page<User> findSearchPage(User user) {
		if (user.hasPager()) {
			return userMapper.selectPage(new Page<>(user.getPageIndex(), user.getPageSize()), new QueryWrapper<>(user));
		}
		return userMapper.selectPage(new Page<>(-1, 1), new QueryWrapper<>(user));
	}

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	public List<User> findSearch(User user) {
		return userMapper.selectList(new QueryWrapper<>(user));
	}

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	public User findById(String id) {
		return this.getById(id);
	}

	/**
	 * 增加
	 * 
	 * @param user
	 */
	public void add(User user) {
		user.setUserId(idWorker.nextId());
		// 密码加密
		user.setPassword(encoder.encode(user.getPassword()));
		user.setFollowcount(0);// 关注数
		user.setFanscount(0);// 粉丝数
		user.setOnline(0L);// 在线时长
		user.setCreatetime(new Date());// 注册日期
		user.setUpdatetime(new Date());// 更新日期
		user.setLastdate(new Date());// 最后登陆日期
		userMapper.insert(user);
	}

	/**
	 * 修改
	 * 
	 * @param user
	 */
	public void update(User user) {
		userMapper.updateById(user);
	}

	/**
	 * 删除 必须有admin角色才能删除
	 * 
	 * @param id
	 */
	public void deleteById(String id) {
		String token = (String) request.getAttribute("claims_admin");
		if (token == null || "".equals(token)) {
			throw new RuntimeException("权限不足！");
		}
		userMapper.deleteById(id);
	}

	public void sendSms(String mobile) {
		// 生成六位数字随机数
		String checkcode = RandomTool.randomNumeric(6);
		// 向缓存中放一份
		redisTemplate.opsForValue().set("checkcode_" + mobile, checkcode, 6, TimeUnit.HOURS);
		// 给用户发一份
		Map<String, String> map = new HashMap<>();
		map.put("mobile", mobile);
		map.put("checkcode", checkcode);
		// rabbitTemplate.convertAndSend("sms", map);
		// 在控制台显示一份【方便测试】
		System.out.println("验证码为：" + checkcode);
	}

	public User login(String mobile, String password) {
		List<User> users = this.lambdaQuery().eq(User::getMobile, mobile).list();
		if (ListTool.isNotEmpty(users)) {
			if (users.size() > 1) {
				throw new ResultException("用户手机号重复,请联系相关人员");
			}
			if (encoder.matches(password, users.get(0).getPassword())) {
				return users.get(0);
			}
		}
		return null;
	}

	@Transactional
	public void updatefanscountandfollowcount(int x, String userid, String friendid) {
		this.lambdaUpdate().setSql("fanscount = fanscount+1").eq(User::getUserId, friendid).update();
		this.lambdaUpdate().setSql("followcount = followcount+1").eq(User::getUserId, userid).update();
	}
}
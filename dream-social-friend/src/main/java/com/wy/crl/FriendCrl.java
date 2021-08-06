package com.wy.crl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wy.client.UserClient;
import com.wy.enums.TipEnum;
import com.wy.result.Result;
import com.wy.service.FriendService;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/friend")
public class FriendCrl {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private FriendService friendService;

	@Autowired
	private UserClient userClient;

	/**
	 * 添加好友或者添加非好友
	 * 
	 * @return
	 */
	@PutMapping("/like/{friendid}/{type}")
	public Result<?> addFriend(@PathVariable String friendid, @PathVariable String type) {
		// 验证是否登录，并且拿到当前登录的用户id
		Claims claims = (Claims) request.getAttribute("claims_user");
		if (claims == null) {
			// 说明当前用户没有user角色
			return Result.error(TipEnum.TIP_ROLE_PERMISSION_DENIED);
		}
		// 得到当前登录的用户id
		String userid = claims.getId();
		// 判断是添加好友还是添加非好友
		if (type != null) {
			if (type.equals("1")) {
				// 添加好友
				int flag = friendService.addFriend(userid, friendid);
				if (flag == 0) {
					return Result.error("不能重复添加好友");
				}
				if (flag == 1) {
					userClient.updatefanscountandfollowcount(userid, friendid, 1);
					return Result.ok();
				}
			} else if (type.equals("2")) {
				// 添加非好友
				int flag = friendService.addNoFriend(userid, friendid);
				if (flag == 0) {
					return Result.error("不能重复添加非好友");
				}
				if (flag == 1) {
					return Result.ok("添加成功");
				}
			}
			return Result.error(TipEnum.TIP_PARAM);
		} else {
			return Result.error(TipEnum.TIP_PARAM);
		}
	}

	@DeleteMapping("/{friendid}")
	public Result<?> deleteFriend(@PathVariable String friendid) {
		// 验证是否登录,并且拿到当前登录的用户id
		Claims claims = (Claims) request.getAttribute("claims_user");
		if (claims == null) {
			// 说明当前用户没有user角色
			return Result.error(TipEnum.TIP_ROLE_PERMISSION_DENIED);
		}
		// 得到当前登录的用户id
		String userid = claims.getId();
		friendService.deleteFriend(userid, friendid);
		userClient.updatefanscountandfollowcount(userid, friendid, -1);
		return Result.ok();
	}
}
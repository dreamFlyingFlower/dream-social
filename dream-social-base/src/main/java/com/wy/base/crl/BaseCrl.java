package com.wy.base.crl;

// import com.alibaba.fastjson.JSON;
// import com.ssi.constant.UserConstant;
// import com.ssi.entity.User;

import io.swagger.annotations.Api;

/**
 * 基础请求API
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:03:02
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Api(tags = "基础请求API")
public interface BaseCrl {
	//
	// /**
	// * 判断请求是否为ajax请求
	// *
	// * @param request 请求
	// * @return true->是,false->否
	// */
	// @ApiOperation(value = "判断请求是否为ajax请求", hidden = true)
	// public static boolean isAjaxRequest(HttpServletRequest request) {
	// return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	// }
	//
	// /**
	// * 从Shiro中获得登录用户信息
	// *
	// * @return 用户信息,可能为null
	// */
	// @ApiOperation(value = "从Shiro中获得登录用户信息", hidden = true)
	// default User getCurrentUser() {
	// ServletRequestAttributes attributes = (ServletRequestAttributes)
	// RequestContextHolder.getRequestAttributes();
	// HttpServletRequest request = attributes.getRequest();
	// Object object =
	// request.getSession().getAttribute(UserConstant.LOGIN_USER_KEY);
	// if (object == null) {
	// throw new AuthorizationException();
	// }
	// return JSON.parseObject(JSON.toJSONString(object), User.class);
	// }
}
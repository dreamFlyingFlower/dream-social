package com.wy.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * JWT配置类
 *
 * @author 飞花梦影
 * @date 2021-07-30 14:20:29
 * @git {@link https://github.com/dreamFlyingFlower }
 */
@Getter
@Setter
public class JwtProperties {

	/** JWT的key */
	private String key;

	/** 超时时间,单位毫秒 */
	private long ttl = 0;
}
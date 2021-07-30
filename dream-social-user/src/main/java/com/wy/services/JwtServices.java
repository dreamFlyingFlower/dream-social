package com.wy.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wy.properties.ConfigProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWT工具类
 * 
 * @author 飞花梦影
 * @date 2021-07-30 14:34:56
 * @git {@link https://github.com/dreamFlyingFlower }
 */
@Component
public class JwtServices {

	@Autowired
	private ConfigProperties config;

	/**
	 * 生成JWT
	 *
	 * @param id 标识符
	 * @param subject 内容
	 * @param roles 其他需要添加到里面的内容
	 * @return jwt加密后的字符串
	 */
	public String createJwt(Long id, String subject, String roles) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder().setId(id + "").setSubject(subject).setIssuedAt(now)
				.signWith(SignatureAlgorithm.HS256, config.getJwt().getKey()).claim("roles", roles);
		if (config.getJwt().getTtl() > 0) {
			builder.setExpiration(new Date(nowMillis + config.getJwt().getTtl()));
		}
		return builder.compact();
	}

	/**
	 * 解析JWT
	 * 
	 * @param jwtStr jwt字符串
	 * @return 解析后的结果,是一个类似map的结构
	 */
	public Claims parseJWT(String jwtStr) {
		return Jwts.parser().setSigningKey(config.getJwt().getKey()).parseClaimsJws(jwtStr).getBody();
	}
}
package com.wy.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义配置类
 *
 * @author 飞花梦影
 * @date 2021-07-30 14:20:14
 * @git {@link https://github.com/dreamFlyingFlower }
 */
@ConfigurationProperties(prefix = "config")
@Configuration
@Getter
@Setter
public class ConfigProperties {

	private JwtProperties jwt = new JwtProperties();
}
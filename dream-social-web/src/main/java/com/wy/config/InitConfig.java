package com.wy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wy.utils.IdWorker;

/**
 * 初始化配置
 * 
 * @author 飞花梦影
 * @date 2021-08-02 14:44:57
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Configuration
public class InitConfig {

	@Bean
	public IdWorker idWorkker() {
		return new IdWorker(1, 1);
	}
}
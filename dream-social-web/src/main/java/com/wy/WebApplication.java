package com.wy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 主要API调用
 * 
 * @author 飞花梦影
 * @date 2021-08-02 15:21:28
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
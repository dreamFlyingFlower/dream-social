package com.wy.client.impl;

import org.springframework.stereotype.Component;

import com.wy.client.BaseClient;
import com.wy.result.Result;

@Component
public class BaseClientImpl implements BaseClient {

	@Override
	public Result<?> findById(String labelId) {
		return Result.error("熔断器触发了！");
	}
}
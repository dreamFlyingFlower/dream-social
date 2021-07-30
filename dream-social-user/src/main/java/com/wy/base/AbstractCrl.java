package com.wy.base;

import java.io.Serializable;

import io.swagger.annotations.Api;

/**
 * 通用增删改API
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:13:29
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Api(tags = "通用增删改API")
public abstract class AbstractCrl<T, ID extends Serializable> extends QueryCrl<T, ID> {
}
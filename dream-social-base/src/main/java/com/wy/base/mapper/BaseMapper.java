package com.wy.base.mapper;

import java.io.Serializable;

/**
 * 通用Mapper数据层接口
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:19:02
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface BaseMapper<T, ID extends Serializable> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {

}
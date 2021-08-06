package com.wy.valid;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * 在进行通用增删改查的时候,校验新增参数的标识
 * 
 * @author 飞花梦影
 * @date 2019-07-01 09:38:24
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@GroupSequence({ ValidCreate.class, Default.class })
public interface ValidCreates {

}
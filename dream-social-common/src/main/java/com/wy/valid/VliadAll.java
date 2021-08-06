package com.wy.valid;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * 实体类参数校验,检验所有组别
 *
 * @author 飞花梦影
 * @date 2021-07-31 20:12:37
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@GroupSequence({ ValidCreate.class, ValidEdit.class, Default.class })
public interface VliadAll {

}
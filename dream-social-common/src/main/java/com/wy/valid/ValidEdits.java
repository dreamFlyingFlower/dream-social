package com.wy.valid;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * 在进行通用增删改查的时候,校验修改参数的标识
 *
 * @author 飞花梦影
 * @date 2019-07-31 09:38:12
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@GroupSequence({ ValidEdit.class, Default.class })
public interface ValidEdits {

}
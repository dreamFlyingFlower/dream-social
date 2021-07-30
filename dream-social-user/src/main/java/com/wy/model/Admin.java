package com.wy.model;

import com.wy.base.AbstractPager;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 管理员实体类 ts_admin
 * 
 * @author 飞花梦影
 * @date 2021-07-30 13:28:36
 * @git {@link https://github.com/dreamFlyingFlower }
 */
@ApiModel(description = "管理员实体类 ts_admin")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Admin extends AbstractPager {

	private static final long serialVersionUID = -2664116830619526697L;

	private Long adminId;

	private String loginname;

	private String password;

	private String state;
}
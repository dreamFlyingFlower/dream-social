package com.wy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

import com.wy.base.model.AbstractPager;

/**
 * 用户实体类 tb_user
 * 
 * @author 飞花梦影
 * @date 2021-07-30 13:40:56
 * @git {@link https://github.com/dreamFlyingFlower }
 */
@ApiModel(description = "用户实体类 tb_user")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User extends AbstractPager {

	private static final long serialVersionUID = 6938451237445392961L;

	private Long userId;

	private String mobile;

	private String password;

	private String nickname;

	private String sex;

	private LocalDate birthday;

	private String avatar;

	private String email;

	/**
	 * 注册日期
	 */
	@ApiModelProperty("注册日期")
	private Date createtime;

	private Date updatetime;

	/**
	 * 最后登录日期
	 */
	@ApiModelProperty("最后登录日期")
	private Date lastdate;

	/**
	 * 在线时长,单位分钟
	 */
	@ApiModelProperty("在线时长,单位分钟")
	private Long online;

	/**
	 * 兴趣
	 */
	@ApiModelProperty("兴趣")
	private String interest;

	/**
	 * 个性签名
	 */
	@ApiModelProperty("个性签名")
	private String personality;

	/**
	 * 粉丝数
	 */
	@ApiModelProperty("粉丝数")
	private Integer fanscount;

	/**
	 * 关注数
	 */
	@ApiModelProperty("关注数")
	private Integer followcount;
}
package com.wy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 论坛提问表 tb_problem
 * 
 * @auther 飞花梦影
 * @date 2021-08-03 09:25:38
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "论坛提问表 tb_problem")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_problem")
public class Problem implements Serializable {

	private static final long serialVersionUID = 409694364150740318L;

	@Id
	private String id;

	/**
	 * 标题
	 */
	@ApiModelProperty("标题")
	private String title;

	/**
	 * 内容
	 */
	@ApiModelProperty("内容")
	private String content;

	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建日期")
	private Date createtime;

	/**
	 * 修改日期
	 */
	@ApiModelProperty("修改日期")
	private Date updatetime;

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private String userid;

	/**
	 * 昵称
	 */
	@ApiModelProperty("昵称")
	private String nickname;

	/**
	 * 浏览量
	 */
	@ApiModelProperty("浏览量")
	private Long visits;

	/**
	 * 点赞数
	 */
	@ApiModelProperty("点赞数")
	private Long thumbup;

	/**
	 * 回复数
	 */
	@ApiModelProperty("回复数")
	private Long reply;

	/**
	 * 是否解决
	 */
	@ApiModelProperty("是否解决")
	private String solve;

	/**
	 * 回复人昵称
	 */
	@ApiModelProperty("回复人昵称")
	private String replyname;

	/**
	 * 回复日期
	 */
	@ApiModelProperty("回复日期")
	private java.util.Date replytime;
}
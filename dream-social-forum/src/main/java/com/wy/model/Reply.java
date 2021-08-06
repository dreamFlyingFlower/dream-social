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
 * 论坛回复表
 * 
 * @auther 飞花梦影
 * @date 2021-08-03 09:28:57
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "论坛回复表")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable {

	private static final long serialVersionUID = -7179553903695579889L;

	@Id
	private String id;

	/**
	 * 问题ID
	 */
	@ApiModelProperty("问题ID")
	private String problemid;

	/**
	 * 回答内容
	 */
	@ApiModelProperty("回答内容")
	private String content;

	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建日期")
	private Date createtime;

	/**
	 * 更新日期
	 */
	@ApiModelProperty("更新日期")
	private Date updatetime;

	/**
	 * 回答用户ID
	 */
	@ApiModelProperty("回答用户ID")
	private String userid;

	/**
	 * 回答人昵称
	 */
	@ApiModelProperty("回答人昵称")
	private String nickname;
}
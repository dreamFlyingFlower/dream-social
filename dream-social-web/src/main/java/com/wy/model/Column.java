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
 * 专栏表 tb_column
 * 
 * @auther 飞花梦影
 * @date 2021-08-02 15:41:08
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "专栏表 tb_column")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_column")
public class Column implements Serializable {

	private static final long serialVersionUID = -741197967174249392L;

	@Id
	private String id;

	/**
	 * 专栏名称
	 */
	@ApiModelProperty("专栏名称")
	private String name;

	/**
	 * 专栏简介
	 */
	@ApiModelProperty("专栏简介")
	private String summary;

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private String userid;

	/**
	 * 申请日期
	 */
	@ApiModelProperty("申请日期")
	private Date createtime;

	/**
	 * 审核日期
	 */
	@ApiModelProperty("审核日期")
	private Date checktime;

	/**
	 * 状态
	 */
	@ApiModelProperty("状态")
	private String state;
}
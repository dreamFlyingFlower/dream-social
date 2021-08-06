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
 * 活动表 tb_gathering
 * 
 * @auther 飞花梦影
 * @date 2021-08-03 08:48:57
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "活动表 tb_gathering")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_gathering")
public class Gathering implements Serializable {

	private static final long serialVersionUID = -1104077571839863036L;

	@Id
	private String id;

	/**
	 * 活动名称
	 */
	@ApiModelProperty("活动名称")
	private String name;

	/**
	 * 大会简介
	 */
	@ApiModelProperty("大会简介")
	private String summary;

	/**
	 * 详细说明
	 */
	@ApiModelProperty("详细说明")
	private String detail;

	/**
	 * 主办方
	 */
	@ApiModelProperty("主办方")
	private String sponsor;

	/**
	 * 活动图片
	 */
	@ApiModelProperty("活动图片")
	private String image;

	/**
	 * 开始时间
	 */
	@ApiModelProperty("开始时间")
	private Date starttime;

	/**
	 * 截止时间
	 */
	@ApiModelProperty("截止时间")
	private Date endtime;

	/**
	 * 举办地点
	 */
	@ApiModelProperty("举办地点")
	private String address;

	/**
	 * 报名截止时间
	 */
	@ApiModelProperty("报名截止时间")
	private java.util.Date enrolltime;

	/**
	 * 是否可见
	 */
	@ApiModelProperty("是否可见")
	private String state;

	/**
	 * 城市
	 */
	@ApiModelProperty("城市")
	private String city;
}
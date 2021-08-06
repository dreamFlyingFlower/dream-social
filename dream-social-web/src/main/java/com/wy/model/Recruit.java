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
 * 招聘表 tb_recruit
 * 
 * @auther 飞花梦影
 * @date 2021-08-03 08:23:42
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "招聘表 tb_recruit")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_recruit")
public class Recruit implements Serializable {

	private static final long serialVersionUID = 624657742939406492L;

	@Id
	private String id;

	/**
	 * 职位名称
	 */
	@ApiModelProperty("职位名称")
	private String jobname;

	/**
	 * 薪资范围
	 */
	@ApiModelProperty("薪资范围")
	private String salary;

	/**
	 * 经验要求
	 */
	@ApiModelProperty("经验要求")
	private String condition;

	/**
	 * 学历要求
	 */
	@ApiModelProperty("学历要求")
	private String education;

	/**
	 * 任职方式
	 */
	@ApiModelProperty("任职方式")
	private String type;

	/**
	 * 办公地址
	 */
	@ApiModelProperty("办公地址")
	private String address;

	/**
	 * 企业ID
	 */
	@ApiModelProperty("企业ID")
	private String eid;

	/**
	 * 创建日期
	 */
	@ApiModelProperty("创建日期")
	private Date createtime;

	/**
	 * 状态
	 */
	@ApiModelProperty("状态")
	private String state;

	/**
	 * 网址
	 */
	@ApiModelProperty("网址")
	private String url;

	/**
	 * 标签
	 */
	@ApiModelProperty("标签")
	private String label;

	/**
	 * 职位描述
	 */
	@ApiModelProperty("职位描述")
	private String content1;

	/**
	 * 职位要求
	 */
	@ApiModelProperty("职位要求")
	private String content2;
}
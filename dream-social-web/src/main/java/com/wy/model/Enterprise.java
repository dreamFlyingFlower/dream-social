package com.wy.model;

import java.io.Serializable;

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
 * 企业表 tb_enterprise
 * 
 * @auther 飞花梦影
 * @date 2021-08-03 08:20:42
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "企业表 tb_enterprise")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_enterprise")
public class Enterprise implements Serializable {

	private static final long serialVersionUID = 8996529486539426807L;

	/**
	 * 主键编号
	 */
	@ApiModelProperty("主键编号")
	@Id
	private String id;

	/**
	 * 企业名称
	 */
	@ApiModelProperty("企业名称")
	private String name;

	/**
	 * 企业简介
	 */
	@ApiModelProperty("企业简介")
	private String summary;

	/**
	 * 企业地址
	 */
	@ApiModelProperty("企业地址")
	private String address;

	/**
	 * 标签列表
	 */
	@ApiModelProperty("标签列表")
	private String labels;

	/**
	 * 坐标
	 */
	@ApiModelProperty("坐标")
	private String coordinate;

	/**
	 * 是否热门:默认0非热门;1热门
	 */
	@ApiModelProperty("是否热门:默认0非热门;1热门")
	private String ishot;

	/**
	 * 企业LOGO
	 */
	@ApiModelProperty("企业LOGO")
	private String logo;

	/**
	 * 职位数
	 */
	@ApiModelProperty("职位数")
	private Integer jobcount;

	/**
	 * URL
	 */
	@ApiModelProperty("URL")
	private String url;
}
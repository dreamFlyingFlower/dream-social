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
 * 文章表 tb_article
 * 
 * @auther 飞花梦影
 * @date 2021-08-02 15:36:15
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "文章表 tb_article")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_article")
public class Article implements Serializable {

	private static final long serialVersionUID = 7948469161575580888L;

	@Id
	private String id;// ID

	/**
	 * 专栏ID
	 */
	@ApiModelProperty("专栏ID")
	private String columnid;

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
	private String userid;

	/**
	 * 标题
	 */
	@ApiModelProperty("标题")
	private String title;

	/**
	 * 文章正文
	 */
	@ApiModelProperty("文章正文")
	private String content;

	/**
	 * 文章封面图片地址
	 */
	@ApiModelProperty("文章封面图片地址")
	private String image;

	/**
	 * 发表日期
	 */
	@ApiModelProperty("发表日期")
	private java.util.Date createtime;

	/**
	 * 修改日期
	 */
	@ApiModelProperty("修改日期")
	private java.util.Date updatetime;

	/**
	 * 是否公开
	 */
	@ApiModelProperty("是否公开")
	private String ispublic;

	/**
	 * 是否置顶
	 */
	@ApiModelProperty("是否置顶")
	private String istop;

	/**
	 * 浏览量
	 */
	@ApiModelProperty("浏览量")
	private Integer visits;

	/**
	 * 点赞数
	 */
	@ApiModelProperty("点赞数")
	private Integer thumbup;

	/**
	 * 评论数
	 */
	@ApiModelProperty("评论数")
	private Integer comment;

	/**
	 * 审核状态
	 */
	@ApiModelProperty("审核状态")
	private String state;

	/**
	 * 所属频道
	 */
	@ApiModelProperty("所属频道")
	private String channelid;

	/**
	 * 文章URL
	 */
	@ApiModelProperty("文章URL")
	private String url;

	/**
	 * 文章类型
	 */
	@ApiModelProperty("文章类型")
	private String type;
}
package com.wy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wy.base.model.AbstractPager;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 标签表 tb_label
 * 
 * @auther 飞花梦影
 * @date 2021-08-01 15:02:56
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "标签表 tb_label")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@TableName("tb_label")
public class Label extends AbstractPager {

	private static final long serialVersionUID = -6946360972510402913L;

	@ApiModelProperty("主键编号")
	private Long id;

	@ApiModelProperty("标签名称")
	private String labelname;

	@ApiModelProperty("状态")
	private String state;

	@ApiModelProperty("使用数量")
	private Long count;

	@ApiModelProperty("关注数")
	private Long fans;

	@ApiModelProperty("是否推荐")
	private String recommend;
}
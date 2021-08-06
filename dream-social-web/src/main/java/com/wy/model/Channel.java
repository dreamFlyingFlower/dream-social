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
 * 频道表 tb_channel
 * 
 * @auther 飞花梦影
 * @date 2021-08-02 15:40:28
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "频道表 tb_channel")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_channel")
public class Channel implements Serializable {

	private static final long serialVersionUID = -8414969155212614635L;

	@Id
	private String id;

	/**
	 * 频道名称
	 */
	@ApiModelProperty("频道名称")
	private String name;

	/**
	 * 状态
	 */
	@ApiModelProperty("状态")
	private String state;
}
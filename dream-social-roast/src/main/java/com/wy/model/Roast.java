package com.wy.model;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * 吐槽表 tb_roast
 * 
 * @auther 飞花梦影
 * @date 2021-08-03 09:57:40
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "吐槽表 tb_roast")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Roast implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String _id;

	private String content;

	private Date publishtime;

	private String userid;

	private String nickname;

	private Integer visits;

	private Integer thumbup;

	private Integer share;

	private Integer comment;

	private String state;

	private String parentid;
}
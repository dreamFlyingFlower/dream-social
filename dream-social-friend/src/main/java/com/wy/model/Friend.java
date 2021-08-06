package com.wy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * 好友表 tb_friend
 * 
 * @auther 飞花梦影
 * @date 2021-08-02 14:52:45
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "好友表 tb_friend")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_friend")
@IdClass(Friend.class)
public class Friend implements Serializable {

	private static final long serialVersionUID = 3517378187455187446L;

	@Id
	private String friendid;

	@Id
	private String userid;

	private String islike;
}
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
 * 非好友表 tb_nofriend
 * 
 * @auther 飞花梦影
 * @date 2021-08-02 14:53:19
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "非好友表 tb_nofriend")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tb_nofriend")
@IdClass(NoFriend.class)
public class NoFriend implements Serializable {

	private static final long serialVersionUID = -6459696673349134423L;

	@Id
	private String userid;

	@Id
	private String friendid;
}
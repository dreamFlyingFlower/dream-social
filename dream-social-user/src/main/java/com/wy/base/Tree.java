package com.wy.base;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 树形结构数据
 *
 * @author 飞花梦影
 * @date 2021-04-22 13:08:31
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel("树形结构数据")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Tree {

	/**
	 * 树形结构每层编号
	 */
	@ApiModelProperty("树形结构每层编号")
	private String treeId;

	/**
	 * 树形结构每层名称
	 */
	@ApiModelProperty("树形结构每层名称")
	private String treeName;

	/**
	 * 树形结构每层编码,treeId和treeCode必须有一个唯一
	 */
	@ApiModelProperty("树形结构每层编码,treeId和treeCode必须有一个唯一")
	private String treeCode;

	/**
	 * 树形结构中的扩展数据
	 */
	@ApiModelProperty("树形结构中的扩展数据")
	private Map<String, Object> extra;

	/**
	 * 树形结构本层数据的下级数据个数
	 */
	@ApiModelProperty("树形结构本层数据的下级数据个数")
	private Long childNum;

	/**
	 * 下级节点数据
	 */
	@ApiModelProperty("下级节点数据")
	private List<Tree> children;
}
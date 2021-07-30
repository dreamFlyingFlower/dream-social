package com.wy.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wy.common.Constant;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 分页参数
 *
 * @author 飞花梦影
 * @date 2021-04-20 13:47:08
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Pager implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 分页,从第几页开始查询 */
	@ApiModelProperty("分页,从第几页开始查询")
	@JsonIgnore
	private Integer pageIndex;

	/** 分页,每页查询数据条数 */
	@ApiModelProperty("分页,每页查询数据条数")
	@JsonIgnore
	private Integer pageSize;

	/** 查询创建日期的开始时间 */
	@ApiModelProperty("查询创建日期的开始时间")
	@JsonIgnore
	private String beginCreatetime;

	/** 查询创建日期的结束时间 */
	@ApiModelProperty("查询创建日期的结束时间")
	@JsonIgnore
	private String endCreatetime;

	/** 查询更新时间的开始时间 */
	@ApiModelProperty("查询更新时间的开始时间")
	@JsonIgnore
	private String beginUpdatetime;

	/** 查询更新时间的结束时间 */
	@ApiModelProperty("查询更新时间的结束时间")
	@JsonIgnore
	private String endUpdatetime;

	/** 排序字段,多个用逗号隔开 */
	@ApiModelProperty("排序字段,多个用逗号隔开")
	@JsonIgnore
	private String pageOrder;

	/** 升序或降序,升级asc,降序desc */
	@ApiModelProperty("升序或降序,升级asc,降序desc")
	@JsonIgnore
	private String pageDirection;

	protected boolean hasPager() {
		if (null == pageIndex || pageIndex <= 0) {
			return false;
		}
		if (null == pageSize || pageSize <= 0) {
			pageSize = Constant.PAGE_SIZE;
		}
		return true;
	}
}
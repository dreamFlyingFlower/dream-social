package com.wy.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 文章表 tb_article
 * 
 * @auther 飞花梦影
 * @date 2021-08-02 10:35:53
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@ApiModel(description = "文章表 tb_article")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document(indexName = "tb_article")
@TableName("tb_article")
public class Article extends AbstractPager {

	private static final long serialVersionUID = 4923213944413194387L;

	@TableId(type = IdType.AUTO)
	private String articleId;

	// 是否索引,就是看该域是否能被搜索
	// 是否分词,就表示搜索的时候是整体匹配还是单词匹配
	// 是否存储,就是是否在页面上显示
	/**
	 * 文章标题
	 */
	@ApiModelProperty("文章标题")
	@Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String title;

	/**
	 * 文章内容
	 */
	@ApiModelProperty("文章内容")
	@Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String content;

	/**
	 * 审核状态
	 */
	@ApiModelProperty("审核状态")
	private String state;
}
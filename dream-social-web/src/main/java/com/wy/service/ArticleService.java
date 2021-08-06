package com.wy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.wy.model.Article;

/**
 * 文章业务接口
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:39:13
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface ArticleService {

	void examine(String id);

	void updateThumbup(String id);

	/**
	 * 查询全部列表
	 * 
	 * @return
	 */
	List<Article> findAll();

	/**
	 * 条件查询+分页
	 * 
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	Page<Article> findSearch(Map<String, Object> whereMap, int page, int size);

	/**
	 * 条件查询
	 * 
	 * @param whereMap
	 * @return
	 */
	List<Article> findSearch(Map<String, Object> whereMap);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	Article findById(String id);

	/**
	 * 增加
	 * 
	 * @param article
	 */
	void add(Article article);

	/**
	 * 修改
	 * 
	 * @param article
	 */
	void update(Article article);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	void deleteById(String id);
}
package com.wy.service;

import org.springframework.data.domain.Page;

import com.wy.model.Article;

/**
 * 文章业务层接口
 * 
 * @author 飞花梦影
 * @date 2021-07-30 13:41:28
 * @git {@link https://github.com/dreamFlyingFlower }
 */
public interface ArticleService {

	Article save(Article article);

	Page<Article> findByKey(String key, int page, int size);
}
package com.wy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wy.mapper.ArticleMapper;
import com.wy.model.Article;
import com.wy.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public Article save(Article article) {
		return articleMapper.save(article);
	}

	@Override
	public Page<Article> findByKey(String key, int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		return articleMapper.findByTitleOrContentLike(key, key, pageable);
	}
}
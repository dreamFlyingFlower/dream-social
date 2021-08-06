package com.wy.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.wy.model.Article;

public interface ArticleMapper extends ElasticsearchRepository<Article, String> {

	Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
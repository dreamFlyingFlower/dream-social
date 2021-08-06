package com.wy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wy.model.Article;

/**
 * 文章数据层
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:36:28
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

	@Modifying
	@Query(value = "UPDATE tb_article SET state = 1 WHERE id = ?", nativeQuery = true)
	void examine(String id);

	@Modifying
	@Query(value = "UPDATE tb_article SET thumbup = thumbup+1 WHERE id = ?", nativeQuery = true)
	void updateThumbup(String id);
}
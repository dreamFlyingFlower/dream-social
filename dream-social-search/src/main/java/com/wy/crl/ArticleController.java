package com.wy.crl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wy.model.Article;
import com.wy.result.Result;
import com.wy.service.ArticleService;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@PostMapping("save")
	public Result<?> save(@RequestBody Article article) {
		return Result.ok(articleService.save(article));
	}

	@GetMapping("/{key}/{page}/{size}")
	public Result<?> findByKey(@PathVariable String key, @PathVariable int page, @PathVariable int size) {
		Page<Article> pageData = articleService.findByKey(key, page, size);
		return Result.page(pageData.getContent(), pageData.getNumber(), pageData.getSize(),
				pageData.getTotalElements());
	}
}
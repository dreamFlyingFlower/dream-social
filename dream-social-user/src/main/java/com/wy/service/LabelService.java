package com.wy.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.base.service.BaseService;
import com.wy.model.Label;

/**
 * Label业务接口
 * 
 * @auther 飞花梦影
 * @date 2021-08-01 16:03:29
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface LabelService extends BaseService<Label, Long> {

	List<Label> findAll();

	Label findById(String id);

	void update(Label label);

	void delete(String labelId);

	List<Label> findSearch(Label label);

	Page<Label> pageQuery(Label label, int page, int size);
}
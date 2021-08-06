package com.wy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.base.service.AbstractService;
import com.wy.lang.StrTool;
import com.wy.mapper.LabelMapper;
import com.wy.model.Label;
import com.wy.service.LabelService;
import com.wy.utils.IdWorker;

@Service
@Transactional
public class LabelServiceImpl extends AbstractService<LabelMapper, Label, Long> implements LabelService {

	@Autowired
	private LabelMapper labelMapper;

	@Autowired
	private IdWorker idWorker;

	public boolean save(Label label) {
		label.setId(idWorker.nextId());
		labelMapper.insert(label);
		return true;
	}

	public List<Label> findAll() {
		return this.lambdaQuery().list();
	}

	public Label findById(String id) {
		return this.getById(id);
	}

	public void update(Label label) {
		labelMapper.updateById(label);
	}

	public void delete(String labelId) {
		labelMapper.deleteById(labelId);
	}

	public List<Label> findSearch(Label label) {
		return this.lambdaQuery().like(Label::getLabelname, label.getLabelname())
				.eq(StrTool.isNotBlank(label.getState()), Label::getState, label.getState()).list();
	}

	public Page<Label> pageQuery(Label label, int page, int size) {
		return this.lambdaQuery().like(Label::getLabelname, label.getLabelname())
				.eq(StrTool.isNotBlank(label.getState()), Label::getState, label.getState())
				.page(new Page<>(page, size));
	}
}
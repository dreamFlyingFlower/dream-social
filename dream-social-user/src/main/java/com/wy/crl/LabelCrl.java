package com.wy.crl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.model.Label;
import com.wy.result.Result;
import com.wy.service.LabelService;

@RestController
@RequestMapping("/label")
@CrossOrigin
@RefreshScope
public class LabelCrl {

	@Autowired
	private LabelService labelService;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(method = RequestMethod.POST)
	public Result<?> save(@RequestBody Label label) {
		labelService.save(label);
		return Result.ok();
	}

	@RequestMapping(method = RequestMethod.GET)
	public Result<?> findAll() {
		// 获取头信息
		String header = request.getHeader("Authorization");
		System.out.println(header);

		List<Label> list = labelService.findAll();
		return Result.ok(list);
	}

	@RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
	public Result<?> findById(@PathVariable("labelId") String id) {
		Label label = labelService.findById(id);
		return Result.ok(label);
	}

	@RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
	public Result<?> update(@PathVariable Long labelId, @RequestBody Label label) {
		label.setId(labelId);
		labelService.update(label);
		return Result.ok("修改成功");
	}

	@RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
	public Result<?> delete(@PathVariable String labelId) {
		labelService.delete(labelId);
		return Result.ok("删除成功");
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Result<?> findSearch(@RequestBody Label label) {
		List<Label> list = labelService.findSearch(label);
		return Result.ok(list);
	}

	@RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
	public Result<?> pageQuery(@PathVariable int page, @PathVariable int size, @RequestBody Label label) {
		Page<Label> pageData = labelService.pageQuery(label, page, size);
		return Result.page(pageData.getRecords(), (int) pageData.getCurrent(), (int) pageData.getSize(),
				pageData.getTotal());
	}
}
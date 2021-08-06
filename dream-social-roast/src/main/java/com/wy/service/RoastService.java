package com.wy.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.wy.model.Roast;

public interface RoastService {

	List<Roast> findAll();

	Roast findById(String id);

	void save(Roast spit);

	void update(Roast spit);

	void deleteById(String id);

	Page<Roast> pageQuery(String parentid, int page, int size);

	void addthumbup(String id);
}
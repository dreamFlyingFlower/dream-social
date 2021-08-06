package com.wy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.wy.model.Roast;

public interface RoastRepository extends MongoRepository<Roast, String> {

	Page<Roast> findByParentid(String parentid, Pageable pageable);
}
package com.wy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wy.model.Enterprise;

/**
 * 企业数据层
 * 
 * @author 飞花梦影
 * @date 2021-08-03 08:28:18
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface EnterpriseRepository extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

	// 面向对象的查询语句jphl.jphl类似于hql,hql是hibernate内部面向对象的查询语句
	List<Enterprise> findByIshot(String ishot);
}
package com.wy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wy.model.Column;

/**
 * 栏目数据层
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:37:37
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Repository
public interface ColumnRepository extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column>{
	
}
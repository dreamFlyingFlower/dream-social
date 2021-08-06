package com.wy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wy.model.Recruit;

/**
 * 招聘数据层
 * 
 * @author 飞花梦影
 * @date 2021-08-03 08:28:41
 * @git {@link https://github.com/dreamFlyingFlower}
 */
public interface RecruitRepository extends JpaRepository<Recruit, String>, JpaSpecificationExecutor<Recruit> {

	List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);

	List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
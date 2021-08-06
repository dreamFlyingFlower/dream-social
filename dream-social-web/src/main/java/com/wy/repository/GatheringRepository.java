package com.wy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wy.model.Gathering;

public interface GatheringRepository extends JpaRepository<Gathering, String>, JpaSpecificationExecutor<Gathering> {

}
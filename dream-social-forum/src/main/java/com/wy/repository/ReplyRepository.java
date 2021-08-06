package com.wy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.wy.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, String>, JpaSpecificationExecutor<Reply> {

}
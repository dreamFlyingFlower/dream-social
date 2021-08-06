package com.wy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wy.model.Channel;

/**
 * 频道数据层
 * 
 * @author 飞花梦影
 * @date 2021-08-03 07:37:02
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, String>, JpaSpecificationExecutor<Channel> {

}
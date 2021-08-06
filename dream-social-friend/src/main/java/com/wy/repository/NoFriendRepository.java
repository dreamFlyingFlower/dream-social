package com.wy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wy.model.NoFriend;

public interface NoFriendRepository extends JpaRepository<NoFriend, String> {

	NoFriend findByUseridAndFriendid(String userid, String friendid);
}
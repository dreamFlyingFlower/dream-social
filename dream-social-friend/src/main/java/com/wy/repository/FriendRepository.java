package com.wy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wy.model.Friend;

public interface FriendRepository extends JpaRepository<Friend, String> {

	public Friend findByUseridAndFriendid(String userid, String friendid);

	@Modifying
	@Query(value = "UPDATE tb_friend SET islike=? WHERE userid = ? AND friendid = ?", nativeQuery = true)
	public void updateIslike(String islike, String userid, String friendid);

	@Modifying
	@Query(value = "delete FROM tb_friend WHERE userid = ? AND friendid = ?", nativeQuery = true)
	void deletefriend(String userid, String friendid);
}
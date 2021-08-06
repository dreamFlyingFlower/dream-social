package com.wy.service;

public interface FriendService {

	int addFriend(String userid, String friendid);

	int addNoFriend(String userid, String friendid);

	void deleteFriend(String userid, String friendid);
}
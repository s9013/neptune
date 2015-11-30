package com.boot.service.impl;

import org.springframework.stereotype.Service;

import com.boot.entity.mongo.Friends;
import com.boot.service.iface.IFriendCircle;

/**
*@Auth						jay
*@date						2015年11月26日 上午10:22:45
*/
@Service
public class FriendCircle implements IFriendCircle {

	public void post() {
			System.out.println("post service impl");
	}

	public void getDynamic(String userId) {

	}

	public Friends getFriends(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

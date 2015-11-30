package com.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.boot.entity.mongo.Account;
import com.boot.entity.mongo.Friends;
import com.boot.service.iface.IFriendCircle;
import com.boot.vo.common.ResultVo;

/**
*@Auth						jay
*@date						2015年11月26日 上午10:22:45
*/
@Service
public class FriendCircle implements IFriendCircle {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public ResultVo post() {
			System.out.println("post service impl");
			return new ResultVo(0, "test");
	}

	public void getDynamic(String userId) {

	}

	public Friends getFriends(String userId) {
		Account account = mongoTemplate.findOne(new Query(Criteria.where("username").is(userId)), Account.class);
		Friends friends = mongoTemplate.findOne(new Query(Criteria.where("userId").is( account.getId() )),Friends.class);
		return friends;
	}

}

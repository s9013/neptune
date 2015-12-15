package com.boot.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.boot.entity.mongo.Account;
import com.boot.entity.mongo.Content;
import com.boot.entity.mongo.Friends;
import com.boot.entity.mongo.Post;
import com.boot.service.iface.IFriendCircle;
import com.boot.vo.PostVo;
import com.boot.vo.common.ResultVo;

/**
*@Auth						jay
*@date						2015年11月26日 上午10:22:45
*/
@Service
public class FriendCircle implements IFriendCircle {

	private Logger logger = LoggerFactory.getLogger(FriendCircle.class);
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public ResultVo post(PostVo postVo) {
			logger.info("service : post");

			Account account = mongoTemplate.findOne(new Query(Criteria.where("username").is(postVo.getUser().getUsername())), Account.class);
			
			Post post = new Post();
			Content content = new Content();
			content.setContent(postVo.getContent());
			post.setContent(content);
			
			post.setGroupId(postVo.getGroupId());
			post.setUser(account.getUser());
			
			post.setUserId(account.getId());
			
			mongoTemplate.save(post);
			
			return new ResultVo(0, "ok");
	}

	public java.util.List<Post> getMyDynamic(String userId) {
		Account account = mongoTemplate.findOne(new Query(Criteria.where("username").is(userId)), Account.class);
		java.util.List<Post> posts =	mongoTemplate.find(new Query(Criteria.where("userId").is(account.getId())), Post.class);
		Update update = new Update();
		return posts;
		
	}

	public Friends getFriends(String userId) {
		Account account = mongoTemplate.findOne(new Query(Criteria.where("username").is(userId)), Account.class);
		Friends friends = mongoTemplate.findOne(new Query(Criteria.where("userId").is( account.getId() )),Friends.class);
		return friends;
	}

	public List<Post> getDynamic(String userId) {
		
		
		
		Account account = mongoTemplate.findOne(new Query(Criteria.where("username").is(userId)), Account.class);
		Friends friends = mongoTemplate.findOne(new Query(Criteria.where("userId").is( account.getId() )),Friends.class);
		
		
		// 组list
		java.util.List<Post> posts =	mongoTemplate.find(new Query(Criteria.where("groupId").in( friends.getGroupIdList().toArray()) ), Post.class);
		
		return posts;
	}

}

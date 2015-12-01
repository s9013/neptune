package com.boot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.boot.entity.mongo.Account;
import com.boot.entity.mongo.Friends;
import com.boot.entity.mongo.Group;
import com.boot.entity.mongo.User;
import com.boot.service.iface.IAccountService;
import com.boot.vo.AccountVo;
import com.boot.vo.UserVo;
import com.boot.vo.common.ResultVo;

/** 
* @ClassName: 		AccountService 
* @Description: 	
* @author 			Jay
* @date 			2015年11月26日 下午9:38:39  
*/
@Service
public class AccountService implements IAccountService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public ResultVo addAccount(AccountVo accountVo) {
		
		try {
			// 帐号
			Account account = new Account();
			account.setUsername(accountVo.getUsername());
			account.setPassword(accountVo.getPassword());

			// 用户信息
			User user = new User();
			user.setUsername(accountVo.getUsername());
			mongoTemplate.save(user);
			account.setUser(user);
			account.setId(user.getId());
			mongoTemplate.save(account);
			
			// 朋友 逻辑的插入 是否好
			// 组
			Group group = new Group();
			group.setName("我的好友");
			List<User> users = new ArrayList<User>();
			group.setUsers(users);
			mongoTemplate.save(group);
			
			// 关系表
			Friends friends = new Friends();
			friends.setUserId(user.getId());
			List<Group> groups = new ArrayList<Group>();
			groups.add(group);
			friends.setGroupList(groups);
			mongoTemplate.save(friends);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResultVo();
	}

	public ResultVo login(AccountVo accountVo) {
		ResultVo resultVo = new ResultVo();
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(accountVo.getUsername()));
		Account account = mongoTemplate.findOne(query, Account.class);
		if(account == null){
			resultVo.setCode(1001);
			resultVo.setInfo("用户不存在！");
		}else{
			if(account.getPassword().equals(accountVo.getPassword())){
				resultVo.setCode(0);
				resultVo.setInfo("登入成功！");
			}else{
				resultVo.setCode(1002);
				resultVo.setInfo("密码错误!");
			}
		}
		
		return resultVo;
	}

	public UserVo getCurrentUser(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		Account account = mongoTemplate.findOne(query, Account.class);
		
		UserVo userVo = new UserVo();
		if(account != null){
			userVo.setId(account.getId());
			userVo.setUsername(account.getUser().getUsername());
		}
		
		return userVo;
	}

}


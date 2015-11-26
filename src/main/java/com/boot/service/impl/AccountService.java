package com.boot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.boot.entity.mongo.Account;
import com.boot.entity.mongo.User;
import com.boot.service.iface.IAccountService;
import com.boot.vo.AccountVo;
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
			mongoTemplate.save(user);
			account.setUser(user);
			
			mongoTemplate.save(account);
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

}


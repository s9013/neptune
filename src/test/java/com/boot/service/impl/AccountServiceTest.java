package com.boot.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boot.service.iface.IAccountService;
import com.boot.vo.AccountVo;
import com.boot.vo.common.ResultVo;

/** 
* @ClassName: 		AccountServiceTest 
* @Description: 	
* @author 			Jay
* @date 			2015年11月26日 下午9:47:27  
*/
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={ "classpath:META-INF/spring/applicationContext.xml", 
		"classpath:META-INF/spring/applicationContext-jpa.xml",
		"classpath:META-INF/spring/applicationContext-mybatis.xml",
		"classpath:META-INF/spring/applicationContext-mongo.xml"})
public class AccountServiceTest {

	private Logger logger = LoggerFactory.getLogger(AccountServiceTest.class); 
	
	@Autowired
	IAccountService accountService;
	
	/**
	 * 添加用户
	 */
	@Test
	public void testAddAccount() {
		logger.info("add account");
		AccountVo accountVo = new AccountVo("mike", "123456");
		ResultVo resultVo = accountService.addAccount(accountVo);
		
		AccountVo accountVo1 = new AccountVo("jay", "123456");
		ResultVo resultVo1 = accountService.addAccount(accountVo1);
		logger.info(resultVo.toString());
	}

	/**
	 * 测试登入
	 */
	@Test
	public void login() {
		AccountVo accountVo = new AccountVo("1235", "123456");
		ResultVo resultVo = accountService.login(accountVo);
		logger.info("result: " + resultVo.toString());
	}
	
}


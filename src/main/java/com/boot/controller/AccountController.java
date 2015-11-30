package com.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.iface.IAccountService;
import com.boot.vo.AccountVo;
import com.boot.vo.UserVo;
import com.boot.vo.common.ResultVo;

/** 
* @ClassName: 		AccountController 
* @Description: 	
* @author 			Jay
* @date 			2015年11月26日 下午10:25:49  
*/
@RestController
@RequestMapping(value="account")
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(AccountController.class); 
	
	@Autowired
	IAccountService accountService;
	
	/**
	 * 登入
	 * @param accountVo
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public ResultVo login(@RequestBody AccountVo accountVo){
		logger.info("login >>>");
		ResultVo resultVo = accountService.login(accountVo);
		logger.info(resultVo.toString());
		return resultVo;
	}
	
	/**
	 * 注册
	 * @param accountVo
	 * @return
	 */
	@RequestMapping(value="register",method=RequestMethod.POST )
	public ResultVo register(@RequestBody AccountVo accountVo){
		logger.info("register >>>");
		ResultVo resultVo = accountService.addAccount(accountVo);
		logger.info(resultVo.toString());
		return resultVo;
	}
	
	/**
	 * 获取登人用户信息
	 * @param accountVo
	 * @return
	 */
	@RequestMapping(value="getCurrentUserInfo",method=RequestMethod.POST)
	@ResponseBody
	public UserVo getCurrentUserInfo(){
		logger.info("get current user info >>>");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		UserVo vo = accountService.getCurrentUser(userDetails.getUsername());
		logger.info(vo.toString());
		return vo;
	}
}


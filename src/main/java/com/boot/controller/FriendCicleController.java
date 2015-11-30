package com.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.service.iface.IFriendCircle;
import com.boot.vo.AccountVo;
import com.boot.vo.common.ResultVo;

/**
*@Auth						jay
*@date						2015年11月30日 下午5:58:45
*/
@RestController
@RequestMapping(value="account")
public class FriendCicleController {
	
	private Logger logger = LoggerFactory.getLogger(FriendCicleController.class); 
	
	@Autowired
	IFriendCircle friendCircle;
	
	/**
	 * 登入
	 * @param accountVo
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public ResultVo login(){
		logger.info("login >>>");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		ResultVo resultVo = friendCircle.getFriends(userDetails);
		logger.info(resultVo.toString());
		return resultVo;
	}

}

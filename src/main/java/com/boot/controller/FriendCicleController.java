package com.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.mongo.Friends;
import com.boot.service.iface.IFriendCircle;
import com.boot.vo.common.ResultVo;

/**
*@Auth						jay
*@date						2015年11月30日 下午5:58:45
*/
@RestController
@RequestMapping(value="friend")
public class FriendCicleController {
	
	private Logger logger = LoggerFactory.getLogger(FriendCicleController.class); 
	
	@Autowired
	IFriendCircle friendCircle;
	
	/**
	 * 获取朋友
	 */
	@RequestMapping(value="getFriends",method=RequestMethod.POST)
	@ResponseBody
	public Friends getFriends(){
		logger.info("get friends >>>");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		Friends resultVo = friendCircle.getFriends(userDetails.getUsername());
		logger.info(resultVo.toString());
		return resultVo;
	}
	
	/**
	 * postInfo
	 */
	@RequestMapping(value="postInfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultVo postInfo(){
		logger.info("post info >>>");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		ResultVo resultVo = friendCircle.post();
		logger.info(resultVo.toString());
		return resultVo;
	}

}

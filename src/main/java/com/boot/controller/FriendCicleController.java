package com.boot.controller;

import java.util.List;

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

import com.boot.entity.mongo.Friends;
import com.boot.entity.mongo.Post;
import com.boot.entity.mongo.User;
import com.boot.service.iface.IFriendCircle;
import com.boot.vo.PostVo;
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
	 * 发表动态
	 */
	@RequestMapping(value="postInfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultVo postInfo(@RequestBody PostVo postVo){
		logger.info("post info >>>");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		postVo.setUser(new User(userDetails.getUsername()));
		ResultVo resultVo = friendCircle.post(postVo);
		logger.info(resultVo.toString());
		return resultVo;
	}
	
	/**
	 * 获取自己的动态
	 */
	@RequestMapping(value="getMyDynamic",method=RequestMethod.POST)
	@ResponseBody
	public List<Post> getMyDynamic(){
		logger.info("get my dynamic >>>");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		List<Post> resultVo = friendCircle.getMyDynamic(userDetails.getUsername());
		logger.info(resultVo.toString());
		return resultVo;
	}

	/**
	 * 获取别人的动态
	 */
	@RequestMapping(value="getDynamic",method=RequestMethod.POST)
	@ResponseBody
	public List<Post> getDynamic(){
		logger.info("get dynamic >>>");
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		List<Post> resultVo = friendCircle.getDynamic(userDetails.getUsername());
		logger.info(resultVo.toString());
		return resultVo;
	}
	
}

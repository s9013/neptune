package com.boot.service.iface;

import java.util.List;

import com.boot.entity.mongo.Friends;
import com.boot.entity.mongo.Post;
import com.boot.vo.PostVo;
import com.boot.vo.common.ResultVo;

/**
*@Auth						jay
*@date						2015年11月26日 上午10:20:21
*/
public interface IFriendCircle {
	
	
	/**
	 * 发表动态
	 */
	public ResultVo post(PostVo postVO);
	
	
	/**
	 * 获取自己的动态
	 * @param userId
	 */
	public List<Post> getMyDynamic(String userId);
	
	/**
	 * 获取别人的动态
	 * @param userId
	 */
	public List<Post> getDynamic(String userId);
	
	/**
	 * 根据id获取朋友
	 * @param userId
	 * @return
	 */
	public Friends getFriends(String userId);
	
}

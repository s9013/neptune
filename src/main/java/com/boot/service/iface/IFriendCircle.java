package com.boot.service.iface;

import com.boot.entity.mongo.Friends;
import com.boot.vo.common.ResultVo;

/**
*@Auth						jay
*@date						2015年11月26日 上午10:20:21
*/
public interface IFriendCircle {
	
	
	/**
	 * 发表动态
	 */
	public ResultVo post();
	
	
	/**
	 * 获取动态
	 * @param userId
	 */
	public void getDynamic(String userId);
	
	/**
	 * 根据id获取朋友
	 * @param userId
	 * @return
	 */
	public Friends getFriends(String userId);
	
}

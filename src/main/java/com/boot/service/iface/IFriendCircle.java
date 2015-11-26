package com.boot.service.iface;

/**
*@Auth						jay
*@date						2015年11月26日 上午10:20:21
*/
public interface IFriendCircle {
	
	
	/**
	 * 发表动态
	 */
	public void post();
	
	
	/**
	 * 获取动态
	 * @param userId
	 */
	public void getDynamic(String userId);
	
}

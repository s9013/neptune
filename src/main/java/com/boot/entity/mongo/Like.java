package com.boot.entity.mongo;

import java.io.Serializable;

/**
 * @Auth jay
 * @date 2015年11月25日 下午4:47:55
 */
public class Like implements Serializable {

	private static final long serialVersionUID = 8033469548994000541L;

	// 点赞人的id
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}

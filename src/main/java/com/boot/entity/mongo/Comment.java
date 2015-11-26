package com.boot.entity.mongo;

import java.io.Serializable;

/**
 * @Auth jay
 * @date 2015年11月25日 下午4:48:58
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = -5480796463213776975L;

	// id
	@javax.persistence.Id
	private Integer Id;
	
	// 点赞人的id
	private Integer userId;

	// 点赞人的id
	private Integer atUserId;

	// 回复的内容
	private String content;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAtUserId() {
		return atUserId;
	}

	public void setAtUserId(Integer atUserId) {
		this.atUserId = atUserId;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [userId=" + userId + ", atUserId=" + atUserId + ", content=" + content + "]";
	}

}

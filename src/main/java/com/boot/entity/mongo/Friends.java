package com.boot.entity.mongo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
*@Auth						jay
*@date						2015年11月25日 下午5:11:54
*/
@Document(collection="Friends")
public class Friends implements Serializable {

	private static final long serialVersionUID = 1670455761308314907L;

	@Id
	private String id;
	
	private String userId;

	// 朋友列表里的组
	@DBRef
	private List<Group> groupList;

	// 组id list
	private List<String> groupIdList;

	
	public Friends(String userId) {
		this.userId = userId;
	}

	public Friends() {
	}

	public Friends(String userId, List<Group> groupList) {
		this.userId = userId;
		this.groupList = groupList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	public List<String> getGroupIdList() {
		return groupIdList;
	}

	public void setGroupIdList(List<String> groupIdList) {
		this.groupIdList = groupIdList;
	}

	@Override
	public String toString() {
		return "Friends [id=" + id + ", userId=" + userId + ", groupList=" + groupList + "]";
	}


	
	
}

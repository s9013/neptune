package com.boot.entity.mongo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auth jay
 * @date 2015年11月25日 下午5:01:00
 */
@Document(collection="Group")
public class Group implements Serializable {

	private static final long serialVersionUID = -373192969160721590L;

	@Id
	private String id;
	
	// 组名
	private String name;

	// 组里面的人
	@DBRef
	private List<User> users;
	
	// 用户id list
	private List<String>  userIdList;
	
	// 组id list
	private List<String> groupIdList;

	@Override
	public String toString() {
		return "Group [name=" + name + ", userList=" + users + "]";
	}

	public Group() {
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Group(String name, List<String> userIdList) {
		super();
		this.name = name;
		this.userIdList = userIdList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<String> getUserIdList() {
		return userIdList;
	}

	public void setUserIdList(List<String> userIdList) {
		this.userIdList = userIdList;
	}

	public List<String> getGroupIdList() {
		return groupIdList;
	}

	public void setGroupIdList(List<String> groupIdList) {
		this.groupIdList = groupIdList;
	}

	
	
}

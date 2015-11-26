package com.boot.entity.mongo;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auth jay
 * @date 2015年11月25日 下午4:50:59
 */
@Document(collection="User")
public class User implements Serializable {

	private static final long serialVersionUID = 3501553373249187990L;

	@Id
	private String id;

	// 姓名
	private String username;

	// 头像
	private String picture;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", picture=" + picture + "]";
	}

	public User() {
	}

	public User(String username, String picture) {
		super();
		this.username = username;
		this.picture = picture;
	}

}

package com.boot.vo;

import java.io.Serializable;

/**
*@Auth						jay
*@date						2015年11月30日 下午5:05:12
*/
public class UserVo implements Serializable {

	private static final long serialVersionUID = -9132314839089573211L;
	private String username;
	private String id;
	public UserVo() {
		super();
	}
	public UserVo(String username, String id) {
		super();
		this.username = username;
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserVo [username=" + username + ", id=" + id + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}

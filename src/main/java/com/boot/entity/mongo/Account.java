package com.boot.entity.mongo;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName: Account
 * @Description:
 * @author Jay
 * @date 2015年11月26日 下午9:23:41
 */
@Document(collection = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 2422497762978734599L;

	@Id
	private String id;

	@Indexed(unique = true)
	private String username;

	private String password;

	@DBRef
	private User user;

	public Account() {
	}

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", user=" + user + "]";
	}

}

package com.boot.vo;

import java.io.Serializable;

/**
 * @ClassName: AccountVo
 * @Description:
 * @author Jay
 * @date 2015年11月26日 下午9:32:22
 */
public class AccountVo implements Serializable {

	private static final long serialVersionUID = -6606736246321453987L;

	// 用户名
	private String username;

	// 密码
	private String password;

	public AccountVo() {
	}

	public AccountVo(String username, String password) {
		this.username = username;
		this.password = password;
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
		return "AccountVo [username=" + username + ", password=" + password + "]";
	}

}

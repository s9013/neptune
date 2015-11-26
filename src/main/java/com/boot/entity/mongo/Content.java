package com.boot.entity.mongo;

import java.io.Serializable;

/**
 * @Auth jay
 * @date 2015年11月25日 下午4:49:24
 */
public class Content implements Serializable {

	private static final long serialVersionUID = 2757108310946843386L;

	// id
	private String id;

	// 内容
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

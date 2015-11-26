package com.boot.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auth jay
 * @date 2015年11月26日 下午2:31:15
 */
@Document(collection="account")
public class Account {
	@Id
	private String id;
	private Float total;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Float total) {
		super();
		this.total = total;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", total=" + total + "]";
	}

}

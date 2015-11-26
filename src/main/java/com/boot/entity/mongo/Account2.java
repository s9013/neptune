package com.boot.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auth jay
 * @date 2015年11月26日 下午2:31:15
 */
@Document(collection="account2")
public class Account2 {
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

	public Account2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account2(Float total) {
		super();
		this.total = total;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", total=" + total + "]";
	}

}

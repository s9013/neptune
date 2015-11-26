package com.boot.entity.mongo;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Auth jay
 * @date 2015年11月26日 下午2:31:59
 */
@Document(collection="person")
public class Person {

	@Id
	private String id;

	private Integer ssn;
	@DBRef
	private List<Account2> accounts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public List<Account2> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account2> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", ssn=" + ssn + ", accounts=" + accounts + "]";
	}

}

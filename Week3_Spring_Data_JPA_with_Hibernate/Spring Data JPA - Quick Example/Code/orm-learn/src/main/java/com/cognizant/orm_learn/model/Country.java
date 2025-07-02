package com.cognizant.orm_learn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name="country")
public class Country {
	
	@Id
	@Column(name="co_code")
	private String code;
	@Column(name="co_name")
	private String name;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("Code : %s Name : %s", code, name);
	}
}

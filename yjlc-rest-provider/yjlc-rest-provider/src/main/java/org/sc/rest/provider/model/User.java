package org.sc.rest.provider.model;

import java.io.Serializable;

import javax.persistence.Table;

import org.sc.rest.provider.server.base.BaseEntity;

@Table(name="user")
public class User extends BaseEntity implements Serializable{
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}

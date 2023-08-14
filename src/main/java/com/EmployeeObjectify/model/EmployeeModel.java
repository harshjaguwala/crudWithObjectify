package com.EmployeeObjectify.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class EmployeeModel 
{
	@Id
	public Long id;
	@Index
	public String name;
	public int age;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public EmployeeModel(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public EmployeeModel(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public EmployeeModel() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}

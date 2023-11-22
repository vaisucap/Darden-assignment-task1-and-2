package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="data")
public class Student {
	@Id
	public long id;
public String name;
public String age;
public double salary;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(long id, String name, String age, double salary) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.salary = salary; 
}
public long getId() {
	return id; 
}
public void setId(long id) {
	this.id = id;
}
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
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
}

}
package com.schoolmanage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student
{
	@Id
private int id;
private String name;
private String stream;
private int fees;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStream() {
	return stream;
}
public void setStream(String stream) {
	this.stream = stream;
}
public int getFees() {
	return fees;
}
public void setFees(int fees) {
	this.fees = fees;
}

}

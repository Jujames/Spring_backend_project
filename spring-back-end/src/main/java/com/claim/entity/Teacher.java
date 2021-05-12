package com.claim.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="teacher")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, 
property = "id")
public class Teacher {

@Id	
@GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name="id")
private Long id;
	
@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="email")
private String email;

@OneToMany(cascade = CascadeType.ALL, mappedBy ="teacher")
private List<Course> courses;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
	
}
public List<Course> getCourse() {
	return courses;
}
public void setCourse(List<Course> course) {
	this.courses = course;
}

}
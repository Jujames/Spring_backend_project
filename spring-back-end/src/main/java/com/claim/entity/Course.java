package com.claim.entity;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity	
@Table(name="course")
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, 
property = "id")
public class Course {

@GeneratedValue(strategy=GenerationType.IDENTITY)
@Id
@Column(name="id")
private Long id;	

@Column(name="course_name")
private String courseName;

@Column(name="description")
private String description;

@Column(name="course_number")
private int courseNumber;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="teacher_id")
private Teacher teacher;


public Teacher getTeacher() {
	return teacher;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getCourseNumber() {
	return courseNumber;
}

public void setCourseNumber(int courseNumber) {
	this.courseNumber = courseNumber;
}



}

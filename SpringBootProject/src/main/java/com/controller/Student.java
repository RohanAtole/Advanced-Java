package com.controller;

import org.springframework.stereotype.Component;

@Component   //It will create object for you and also push into the Container.
public class Student {

	String StudentName;

	public Student(String studentName) {
		super();
		this.StudentName = studentName;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

}

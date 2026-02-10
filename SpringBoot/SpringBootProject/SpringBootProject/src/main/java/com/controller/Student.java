package com.controller;

//import org.springframework.stereotype.Component;

//@Component   //It will create object for you and also push into the Container.
public class Student {

	String StudentName = "Rohan";

	public Student(String StudentName) {
		super();
		this.StudentName = StudentName;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

}

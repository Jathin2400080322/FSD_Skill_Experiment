package com.klu.beans;

public class Student {
	private int studentId;
	private String name;
	private int year;
	private String email;
	private Course course;
	private String phoneNo;
	public Student(int studentId, String name, int year) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.year = year;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void getStudent() {
		System.out.println("StudentId: " + studentId);
		System.out.println("Name: " + name);
		System.out.println("Year: " + year);
		System.out.println("Email: " + email);
		System.out.println("Phone No: " + phoneNo);
		course.getCourse();
	}
}
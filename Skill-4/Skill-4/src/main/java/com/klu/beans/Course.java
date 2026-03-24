package com.klu.beans;

public class Course {
	private String courseName;
	private int duration;
	public Course(String courseName, int duration) {
		super();
		this.courseName = courseName;
		this.duration = duration;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void getCourse() {
		System.out.println("course name: " + courseName);
		System.out.println("course duration: " + duration);
		
	}

}

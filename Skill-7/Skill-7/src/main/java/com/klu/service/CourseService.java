package com.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.model.Course;
import com.klu.repo.CourseRepo;

@Service
public class CourseService {
	@Autowired
	private CourseRepo courseRepo;
	
	public Course saveCourse(Course c) {
		return courseRepo.save(c);
		
	}
	public List<Course> getAllCourse(){
		return courseRepo.findAll();
	}
	public Course getCourseById(Long id) {
		return courseRepo.findById(id).orElseThrow();
	}
	public Course updateCourse(Long id, Course c) {
		Course cou = courseRepo.findById(id).orElseThrow();
		cou.setDuration(c.getDuration());
		cou.setFee(c.getFee());
		cou.setTitle(c.getTitle());
		courseRepo.save(cou);	
		return cou;
	}
	public String deleteCourse(Long id) {
		courseRepo.findById(id).orElseThrow();
		courseRepo.deleteById(id);
		return "The course is deleted";
		
	}

}

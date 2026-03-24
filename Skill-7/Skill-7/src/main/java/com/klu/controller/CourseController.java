package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Course;
import com.klu.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/saveCourse")
	public ResponseEntity<Course> saveCourse(@RequestBody Course c){
		 return new ResponseEntity<>(courseService.saveCourse(c),HttpStatus.CREATED);
	}
	
	  @GetMapping("/getAllCourse")
	  public ResponseEntity<List<Course>> getAllCourse(){
	    return ResponseEntity.ok(courseService.getAllCourse());
	  }
	  @GetMapping("/getCourseById/{id}")
	  public ResponseEntity<Course> getCourseById(@PathVariable Long id){
		  return ResponseEntity.ok(courseService.getCourseById(id));
	  }
	  @PutMapping("/updateCourse/{id}")
	  public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course c){
		  return ResponseEntity.ok(courseService.updateCourse(id, c));
		  
	  }
	  @DeleteMapping("/deleteCourse/{id}")
	  public ResponseEntity<String> deleteCourse(@PathVariable Long id){
		  return ResponseEntity.ok(courseService.deleteCourse(id));
	  }
	  
	

}

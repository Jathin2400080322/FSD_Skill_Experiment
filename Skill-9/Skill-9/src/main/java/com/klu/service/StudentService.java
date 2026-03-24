package com.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.exception.StudentNotFoundException;
import com.klu.model.Student;
import com.klu.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;
	public Student saveStudent(Student s) {
		return studentRepo.save(s);
	}
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException("Employee not found"));
	}
}

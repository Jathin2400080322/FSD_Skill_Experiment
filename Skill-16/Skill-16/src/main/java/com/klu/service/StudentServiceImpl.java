package com.klu.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.klu.entity.Student;
import com.klu.repository.StudentRepository;
import com.klu.exception.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public Student updateStudent(Long id, Student student) {
        Student existing = getStudentById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());
        return repo.save(existing);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        repo.delete(student);
    }
}
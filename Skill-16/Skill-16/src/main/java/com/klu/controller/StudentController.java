package com.klu.controller;

import com.klu.entity.Student;
import com.klu.service.StudentService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @Operation(summary = "Add a new student")
    @ApiResponse(responseCode = "200", description = "Student created successfully")
    @PostMapping
    public Student create(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @Operation(summary = "Get student by ID")
    @ApiResponse(responseCode = "404", description = "Student not found")
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }
}
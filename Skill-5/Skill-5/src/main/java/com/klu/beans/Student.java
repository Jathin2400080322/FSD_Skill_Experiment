package com.klu.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 10;
    private String name = "Akeera";
    private String gender = "Male";

    @Autowired
    private Certification course;

    public void display() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Gender       : " + gender);
        System.out.println("Course       : " + course);
    }
}

package com.klu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/admin/add")
    public String add() {
        return "Admin Add Access";
    }

    @GetMapping("/admin/delete")
    public String delete() {
        return "Admin Delete Access";
    }

    @GetMapping("/employee/profile")
    public String profile() {
        return "Employee Profile";
    }
}
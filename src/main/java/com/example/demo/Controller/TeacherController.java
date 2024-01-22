package com.example.demo.controller;

import com.example.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TeacherService;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("${app.endpoint.teacherBasePath}")
    public ResponseEntity<Object> saveAdmin(@Validated @RequestBody Teacher teacher) throws Exception {
       Teacher saveteacher = teacherService.saveDetails(teacher);
        return new ResponseEntity<>(saveteacher, HttpStatus.CREATED);
    }
}

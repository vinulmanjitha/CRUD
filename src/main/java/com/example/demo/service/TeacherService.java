package com.example.demo.service;

import com.example.demo.dao.TeacherRepository;
import com.example.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveDetails(Teacher teacher){
        return  teacherRepository.save(teacher);

    }
}

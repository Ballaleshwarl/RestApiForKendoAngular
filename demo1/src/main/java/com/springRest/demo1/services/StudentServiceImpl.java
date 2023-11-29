package com.springRest.demo1.services;

import com.springRest.demo1.entities.Student;
import com.springRest.demo1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements  StudentService{

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
}

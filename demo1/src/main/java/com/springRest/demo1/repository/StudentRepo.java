package com.springRest.demo1.repository;

import com.springRest.demo1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}

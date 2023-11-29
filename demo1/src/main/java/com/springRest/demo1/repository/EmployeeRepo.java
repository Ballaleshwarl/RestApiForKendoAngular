package com.springRest.demo1.repository;

import com.springRest.demo1.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee,Long> {


}

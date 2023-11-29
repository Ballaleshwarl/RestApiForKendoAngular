package com.springRest.demo1.services;

import com.springRest.demo1.entities.Electronics;
import com.springRest.demo1.entities.Employee;
import com.springRest.demo1.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeService{
    public Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();

    public List<Electronics> getElectronics();

    public List<Student> getStudents();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee emp, Long id);

    void deleteEmployee(Long id);


}
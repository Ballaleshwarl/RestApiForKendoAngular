package com.springRest.demo1.controller;

import com.springRest.demo1.entities.Employee;
import com.springRest.demo1.entities.Student;
import com.springRest.demo1.services.ElectronicsService;
import com.springRest.demo1.services.EmployeeService;
import com.springRest.demo1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ElectronicsService electronicsService;

    @Autowired
    private StudentService studentService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    //build create employee rest api

    @GetMapping("/home")
    public String home(){
        return "Home Page!";
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping("/getemp")
    public List<Employee> getAllEmployee(){
     return employeeService.getAllEmployee();

    }

    @GetMapping("/getemp/{id}")
    public ResponseEntity<Employee> getById( @PathVariable Long id){

        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @GetMapping("/getemp/query")
    public ResponseEntity<Object> getData(@RequestParam(name = "id") int id,@RequestParam(name = "value") String value){

        Object obj = null;
       if(Objects.equals(value, "employee")){

           obj =employeeService.getAllEmployee();

           return ResponseEntity.ok(obj);
       }else if(Objects.equals(value, "electronics")){

           obj =electronicsService.getElectronics();

           return ResponseEntity.ok(obj);
       }else if(Objects.equals(value, "students")){

           obj =studentService.getStudents();

           return ResponseEntity.ok(obj);
       }

      return  ResponseEntity.ok(obj);
    }

    @PutMapping("/employee/{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee emp){

        return new ResponseEntity<Employee>(employeeService.updateEmployee(emp,id),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Emp deleted successfully!!!",HttpStatus.OK);
    }






}

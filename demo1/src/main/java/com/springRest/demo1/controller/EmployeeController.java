package com.springRest.demo1.controller;

import com.springRest.demo1.entities.Employee;
import com.springRest.demo1.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

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
    public ResponseEntity<Employee> getData(@RequestParam(name = "id") int id,@RequestParam(name = "fname") String fname){

        System.out.println(id);
        System.out.println(fname);

        Employee e = new Employee();
        e.setId(id);
        e.setfName(fname);

        return ResponseEntity.ok(e);
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

package com.springRest.demo1.services;

import com.springRest.demo1.Exception.ResourceNotFoundException;
import com.springRest.demo1.entities.Employee;
import com.springRest.demo1.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  implements  EmployeeService{
    @Override
    public Employee getEmployeeById(Long id) {
//      Optional<Employee>  employee = employeeRepo.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }else{
//            throw  new ResourceNotFoundException("Employee","Id",id);
//        }
        return employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));

    }

    @Override
    public Employee updateEmployee(Employee emp, Long id) {

        Employee updatedEmp = employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
        updatedEmp.setfName(emp.getfName());
        updatedEmp.setlName(emp.getlName());

        employeeRepo.save(updatedEmp);
        return updatedEmp;
    }

    @Override
    public void deleteEmployee(Long id) {

        employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));

        employeeRepo.deleteById(id);

    }

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}

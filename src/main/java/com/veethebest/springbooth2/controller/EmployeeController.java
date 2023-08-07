package com.veethebest.springbooth2.controller;

import com.veethebest.springbooth2.entity.Employee;
import com.veethebest.springbooth2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping(path = "/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping(path = "/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }
}

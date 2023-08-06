package com.veethebest.springbooth2.service;

import com.veethebest.springbooth2.entity.Employee;
import com.veethebest.springbooth2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployee(int id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getAllEmployees(){
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList;
    }

    public Employee saveEmployee(Employee employee){
        System.out.printf("value of employee"+ employee);
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }
}

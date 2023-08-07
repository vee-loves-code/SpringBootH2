package com.veethebest.springbooth2.repository;

import com.veethebest.springbooth2.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByAge(int age);

    Employee findByEmail(String email);
}

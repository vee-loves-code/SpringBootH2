package com.veethebest.springbooth2.repository;

import com.veethebest.springbooth2.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name); //Custom methods
    List<Employee> findByAge(int age);  //custom methods

    Employee findByEmail(String email); //named query

    @Query(value = "SELECT e FROM Employee e ORDER BY name") //custom query
    public List<Employee> findAllSortedByName();

    @Query(value = "SELECT * FROM Employee ORDER BY name", nativeQuery = true)  //native query
    public List<Employee> findAllSortedByNameUsingNative();

}

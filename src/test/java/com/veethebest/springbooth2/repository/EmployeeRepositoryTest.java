package com.veethebest.springbooth2.repository;

import com.veethebest.springbooth2.SpringbootH2Application;
import com.veethebest.springbooth2.entity.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = SpringbootH2Application.class)
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void findById() {
        Employee employee = getEmployee();
        employeeRepository.save(employee);
        Employee result = employeeRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), result.getId());
    }

    @Test
    public void testFindAll() {
        Employee employee = getEmployee();
        employeeRepository.save(employee);
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(emp -> employeeList.add(employee));
        assertEquals(employeeList.size(), 1);
    }

    @Test
    public void testSave() {
        Employee employee = getEmployee();
        employeeRepository.save(employee);
        Employee employeeFound = employeeRepository.findById(employee.getId()).get();
        assertEquals(employee.getId(), employeeFound.getId());
    }

    @Test
    public void testDeleteById() {
        Employee employee = getEmployee();
        employeeRepository.save(employee);
        employeeRepository.deleteById(employee.getId());
        List<Employee> result = new ArrayList<>();
        employeeRepository.findAll().forEach(e -> result.add(e));
        assertEquals(result.size(), 0);
    }

    @Test
    public void testFindByName() {
        Employee employee = getEmployee();
        employeeRepository.save(employee);
        List<Employee> result = new ArrayList<>();
        employeeRepository.findByName(employee.getName()).forEach(e -> result.add(e));
        assertEquals(result.size(), 1);
    }

    @Test
    public void testFindByAge() {
        Employee employee = getEmployee();
        employeeRepository.save(employee);
        List<Employee> result = new ArrayList<>();
        employeeRepository.findByAge(employee.getAge()).forEach(e -> result.add(e));
        assertEquals(result.size(), 1);
    }

        private Employee getEmployee () {
            Employee employee = new Employee();
            employee.setId(1);
            employee.setName("Mahesh");
            employee.setAge(30);
            employee.setEmail("mahesh@test.com");
            return employee;
        }

    @Test
    public void testFindByEmail(){
        Employee employee = getEmployee();
        employeeRepository.save(employee);
        Employee result = employeeRepository.findByEmail(employee.getEmail());
        assertNotNull(result);
    }

}




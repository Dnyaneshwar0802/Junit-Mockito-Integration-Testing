package com.test.service;

import com.test.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Optional<Employee> findById(int id);
    Optional<Employee> findByUsername(String username);
    Optional<Employee> findByUsernameAndName(String username, String name);
    Optional<Employee> findByNameAndCity(String name, String city);
    List<Employee> findAll();
}

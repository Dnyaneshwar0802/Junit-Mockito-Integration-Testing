package com.test.repository;

import com.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
/*
    public Employee saveEmployee(Employee employee);
*/
   Optional <Employee> findByUsername(String username);
}

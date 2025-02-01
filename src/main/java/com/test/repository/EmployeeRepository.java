package com.test.repository;

import com.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
/*
    public Employee saveEmployee(Employee employee);
*/
    Employee findByUsername(String username);
}

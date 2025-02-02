package com.test.repository;

import com.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

   Optional <Employee> findByUsername(String username);

  @Query("SELECT e FROM Employee e WHERE e.username = ?1 AND e.name = ?2")
  Optional<Employee> findByUsernameAndName(String username,String name);

}

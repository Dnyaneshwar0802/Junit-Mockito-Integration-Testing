package com.test.repository;

import com.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    /*
    Below Method is SB feature findByUsername means it find by username column from table in DB and
   Matches and return Employee if username is valid otherwise return Empty instead of null
   */
   Optional <Employee> findByUsername(String username);
   /*
  Below Method is Custom Query But using JPQL
  inside JPQL you dont need to use @Param annotation alos it is index base not the variable based
  ?1 means it accept value from first parameter etc
 */
  @Query("SELECT e FROM Employee e WHERE e.username = ?1 AND e.name = ?2")
  Optional<Employee> findByUsernameAndName(String username,String name);

}

package com.test.repository;

import com.test.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("SAVE EMPLOYEE METHOD TEST")
    public void givenEmployee_whenSaveEmployee_thenReturnEmployee() {
        //given
        Employee employee = Employee.builder().name("Dnyaneshwar").username("db").salary(4000).build();
        //when
        Employee savedEmployee1 = employeeRepository.save(employee);
        //then
        Assertions.assertThat(savedEmployee1).isNotNull();
        Assertions.assertThat(savedEmployee1.getId()).isEqualTo(1);
        Assertions.assertThat(savedEmployee1.getSalary()).isEqualTo(4000);
    }
    @Test
    @DisplayName("Positive Test CASE fot FindByUsername")
    public void givenEmployee_whenFindByUsernmae_thenReturnEmployee(){
        //given
        String username="gb";
       Employee employee= Employee.builder().name("Gajanan").username("gb").salary(2000).build();
        employeeRepository.save(employee);
        //when
        Optional<Employee> returnedemployee =employeeRepository.findByUsername(username);
        //then
        Assertions.assertThat(returnedemployee.get()).isNotNull();
        Assertions.assertThat(returnedemployee.get()).isInstanceOf(Employee.class);
    }
    @Test
    @DisplayName("NEGATIVE test CASE fot FindByUsername")
    public void givenUsername_whenFindByUsername_thenRetunEmpty(){
     //given
        String username="gb";
        //when
       Optional<Employee> returnedEmployee= employeeRepository.findByUsername(username);
       //then
        Assertions.assertThat(returnedEmployee).isEmpty();
    }
}

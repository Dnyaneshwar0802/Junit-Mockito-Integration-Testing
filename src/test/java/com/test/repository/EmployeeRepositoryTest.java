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
    @Test
    @DisplayName("Positive test CASE fot FindByUsernameAndName")
    public void givenEmployee_whenFindByUsernameAndName_thenRetunEmployee(){
        //given
        Employee employee = Employee.builder().name("Dnyaneshwar").username("db").salary(4000).build();
        employeeRepository.save(employee);
        //when
        Optional<Employee> returnedEmployee= employeeRepository.findByUsernameAndName("db","Dnyaneshwar");
        //then
        Assertions.assertThat(returnedEmployee).isNotEmpty();
        Assertions.assertThat(returnedEmployee.get().getUsername()).isEqualTo("db");
        Assertions.assertThat(returnedEmployee.get().getName()).isEqualTo("Dnyaneshwar");
    }
    @Test
    @DisplayName("Negative test CASE fot FindByUsernameAndName")
    public void givenUsernameAndName_whenFindByUsernameAndName_thenRetunEmpty(){
        //given
        String username="gb";
        String name="Dnya";
        //when
        Optional<Employee> returnedEmployee= employeeRepository.findByUsernameAndName(username,name);
        //then
        Assertions.assertThat(returnedEmployee).isEmpty();
    }
    @Test
    @DisplayName("Positive test CASE fot FindByNameAndCity")
    public void givenEmployeeObject_whenFindByNameAndCity_thenRetunObject(){
        //given
        Employee employee = Employee.builder().name("Dnyaneshwar").city("Nanded").username("db").salary(4000).build();
        employeeRepository.save(employee);
        //when
        Optional<Employee> returnedEmployee= employeeRepository.findByNameAndCity("Dnyaneshwar","Nanded");
        //then
        Assertions.assertThat(returnedEmployee).isNotEmpty();
        Assertions.assertThat(returnedEmployee.get().getName()).isEqualTo("Dnyaneshwar");
        Assertions.assertThat(returnedEmployee.get().getCity()).isEqualTo("Nanded");
    }
    @Test
    @DisplayName("Negative test CASE fot FindByNameAndCity")
    public void givenNameAndCity_whenFindByNameAndCity_thenRetunEmpty(){
        //given
        String city="pune";
        String name="Dnya";
        //when
        Optional<Employee> returnedEmployee= employeeRepository.findByNameAndCity(name,city);
        //then
        Assertions.assertThat(returnedEmployee).isEmpty();
    }
}

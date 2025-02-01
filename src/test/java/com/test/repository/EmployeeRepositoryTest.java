package com.test.repository;

import com.test.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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
}

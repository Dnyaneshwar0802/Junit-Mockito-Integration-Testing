package com.test.service;

import com.test.model.Employee;
import com.test.repository.EmployeeRepository;
import com.test.serviceImpl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeServiceImpl employeeService;
    @Test
    @DisplayName("SAVE EMPLOYEE METHOD SEVICE LAYER TEST")
    public void givenEmployee_whenSaveEmployee_thenReturnEmployee() {
        //given
        Employee employee = Employee.builder().id(1).name("Dnyaneshwar").username("db").salary(4000).build();
        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);
        //when
        Employee savedEmployee1 = employeeService.saveEmployee(employee);
        System.out.println(savedEmployee1.toString());
        //then
        Assertions.assertThat(savedEmployee1).isNotNull();
        Assertions.assertThat(savedEmployee1.getId()).isEqualTo(1);
    }

}

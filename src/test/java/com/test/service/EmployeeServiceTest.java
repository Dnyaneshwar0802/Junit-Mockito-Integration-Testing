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

import java.util.Optional;

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
    @Test
    @DisplayName("Positive Test CASE fot FindByUsername")
    public void givenEmployee_whenFindByUsernmae_thenReturnEmployee() {
        //given
        String username = "gb";
        Employee employee = Employee.builder().name("Gajanan").username("gb").salary(2000).build();

        BDDMockito.given(employeeRepository.findByUsername(username)).willReturn(Optional.of(employee));
        //when
        System.out.println(employee.getUsername());
        Optional<Employee> returnedemployee =employeeService.findByUsername(employee.getUsername());
        System.out.println(returnedemployee.get().toString());
        //then
        Assertions.assertThat(returnedemployee.get()).isNotNull();
    }
    @Test
    @DisplayName("NEGATIVE test CASE fot FindByUsername")
    public void givenUsername_whenFindByUsername_thenRetunEmpty() {
        //given
        String username = "gb";
        BDDMockito.given(employeeRepository.findByUsername(username)).willReturn(Optional.empty());
        //when
        Optional<Employee> returnedEmployee = employeeService.findByUsername(username);
        //then
        Assertions.assertThat(returnedEmployee).isEmpty();
    }
}

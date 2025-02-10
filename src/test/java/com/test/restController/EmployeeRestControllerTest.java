package com.test.restController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.Employee;
import com.test.service.EmployeeService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@WebMvcTest
public class EmployeeRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private EmployeeService employeeService;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Save Employee Controller")
    public void givenEmployee_whenSaveEmployee_thenReturnEmployee() throws Exception {
        //given
        Employee employee = Employee.builder().id(1).name("Dnyaneshwar").username("db").salary(4000).build();
        BDDMockito.given(employeeService.saveEmployee(ArgumentMatchers.any(Employee.class)))
                .willAnswer((x) -> x.getArgument(0));
        //when
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders
                .post("/employeeRestController/saveEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));
        //then
        response.andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(employee.getName())));

    }

    @Test
    @DisplayName("Positive Test Case for FindById")
    public void givenEmployee_whenFindByID_thenReturnEmployee() throws Exception {
        //given :-
        Employee employee = Employee.builder().id(1).name("Dnyaneshwar").city("Nanded").build();
        BDDMockito.given(employeeService.findById(ArgumentMatchers.eq(1)))
                /*.willReturn(Optional.of(employee));*/
        //   .willAnswer(x->x.getArgument(0));
        //above will answer not work
                .willAnswer(invocation -> {
                    int id = invocation.getArgument(0);
                    return id == 1 ? Optional.of(employee) : Optional.empty();
                });
        //when
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/employeeRestController/findById/1")
                .contentType(MediaType.APPLICATION_JSON));


        /* Below that doesnt work
        ResultActions response=mockMvc.perform(MockMvcRequestBuilders.get("/employeeRestController/findById")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(objectMapper.writeValueAsString(employee)));*/
        //then
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Dnyaneshwar"));
        /*response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(employee.getName())));*/
    }
}

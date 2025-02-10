package com.test.restController;

import com.test.model.Employee;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employeeRestController")
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/simpleMessage")
    public String getMessage(){
        return "SB project is working";
    }
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/findById")
    public Optional<Employee> findById(int id){
       return employeeService.findById(id);
    }
}

package com.test.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employeeRestController")
public class EmployeeRestController {
    @GetMapping("/simpleMessage")
    public String getMessage(){
        return "SB project is working";

    }
}

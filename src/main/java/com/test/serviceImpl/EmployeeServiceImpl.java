package com.test.serviceImpl;

import com.test.model.Employee;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        if(employee!=null) {
            Employee savedEmployee1 = employeeRepository.save(employee);
            return savedEmployee1;
        }
        return null;
    }
}

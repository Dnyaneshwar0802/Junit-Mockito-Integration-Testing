package com.test.serviceImpl;

import com.test.model.Employee;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee != null) {
            Employee savedEmployee1 = employeeRepository.save(employee);
            return savedEmployee1;
        }
        return null;
    }

    @Override
    public Optional<Employee> findById(int id) {
        Optional<Employee> returnedEmployee = employeeRepository.findById(id);
        if (returnedEmployee.isPresent()) {
            return returnedEmployee;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findByUsername(String username) {
        Optional<Employee> returnedEmployee = employeeRepository.findByUsername(username);
        return returnedEmployee;
    }

    @Override
    public Optional<Employee> findByUsernameAndName(String username, String name) {
        Optional<Employee> employee = employeeRepository.findByUsernameAndName(username, name);
        if (employee.isPresent()) {
            return employee;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findByNameAndCity(String name, String city) {
        Optional<Employee> employee = employeeRepository.findByNameAndCity(name, city);
        if (employee.isPresent()) {
            return employee;
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeesList = employeeRepository.findAll();
        if (!employeesList.isEmpty()) {
            return employeesList;
        }
        return List.of();
    }


}

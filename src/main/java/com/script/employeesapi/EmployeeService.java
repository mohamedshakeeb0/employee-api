package com.script.employeesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public void createEmployee(Employee employee) {
        repo.saveEmployee(employee);
    }

    public Optional<Employee> getEmployeeById(String id) {
        return repo.getEmployeeById(id);
    }

    public List<Employee> getEmployees(String name, Double fromSalary, Double toSalary) {
        return repo.searchEmployees(name, fromSalary, toSalary);
    }
}

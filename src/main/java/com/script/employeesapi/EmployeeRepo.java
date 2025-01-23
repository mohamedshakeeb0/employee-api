package com.script.employeesapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepo {

    private static final String FILE_PATH = "src/main/resources/employees.json";

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepo.class);

    public List<Employee> getAllEmployees() {
        File file = new File(FILE_PATH);

        try {

            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
        } catch (IOException e) {

            logger.error("Error reading employee data from file: {}", e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public Optional<Employee> getEmployeeById(String id) {

        return getAllEmployees().stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    public void saveEmployee(Employee employee) {

        List<Employee> employees = getAllEmployees();
        employee.setId(String.valueOf(employees.size() + 1));
        employees.add(employee);

        try {
            objectMapper.writeValue(new File(FILE_PATH), employees);
        } catch (IOException e) {
            logger.error("Error saving employee data to file: {}", e.getMessage(), e);
        }
    }

    public List<Employee> searchEmployees(String name, Double fromSalary, Double toSalary) {

        List<Employee> employees = getAllEmployees();
        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            boolean matchesName = name == null ||
                    employee.getFirstName().contains(name) ||
                    employee.getLastName().contains(name);

            boolean matchesSalary = true;

            if (fromSalary != null || toSalary != null) {
                Double employeeSalary = Double.parseDouble(employee.getSalary());

                matchesSalary = (fromSalary == null || employeeSalary >= fromSalary) &&
                        (toSalary == null || employeeSalary <= toSalary);
            }

            if (matchesName && matchesSalary) {
                filteredEmployees.add(employee);
            }
        }
        return filteredEmployees;
    }
}

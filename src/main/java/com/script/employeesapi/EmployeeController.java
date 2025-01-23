package com.script.employeesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {

        employeeService.createEmployee(employee);
        return ResponseEntity.ok().body(new CreateEmployeeResponse(employee.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {

        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Employee> getEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double fromSalary,
            @RequestParam(required = false) Double toSalary) {
        return employeeService.getEmployees(name, fromSalary, toSalary);
    }

    public static class CreateEmployeeResponse {

        private String id;

        public CreateEmployeeResponse(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}

package com.Staffing_Planner.Staffing_Planner.controller;

import com.Staffing_Planner.Staffing_Planner.models.Employee;
import com.Staffing_Planner.Staffing_Planner.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /**
     * List all employees
     */
    @GetMapping
    public List<Employee> listEmployees() {
        return employeeRepo.findAll();
    }

    /**
     * Create a new employee.
     *
     * Example request body:
     * {
     *   "name": "Alice"
     * }
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        // you might want to validate name != null etc.
        return employeeRepo.save(employee);
    }
}
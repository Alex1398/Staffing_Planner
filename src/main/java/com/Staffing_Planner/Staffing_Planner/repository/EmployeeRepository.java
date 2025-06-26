package com.Staffing_Planner.Staffing_Planner.repository;


import com.Staffing_Planner.Staffing_Planner.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {}
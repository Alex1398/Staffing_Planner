package com.Staffing_Planner.Staffing_Planner.repository;

import com.Staffing_Planner.Staffing_Planner.models.Assignment;
import com.Staffing_Planner.Staffing_Planner.models.ShiftType;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;
import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByDate(LocalDate date);
    long countByDateAndShift(LocalDate date, ShiftType shift);
    boolean existsByEmployeeIdAndDate(String employeeId, LocalDate date);
}
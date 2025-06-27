package com.Staffing_Planner.Staffing_Planner.dto;

import com.Staffing_Planner.Staffing_Planner.models.Employee;
import com.Staffing_Planner.Staffing_Planner.models.ShiftType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record AssignDTO(
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        ShiftType shift,
        List<String> employeeIds) {}
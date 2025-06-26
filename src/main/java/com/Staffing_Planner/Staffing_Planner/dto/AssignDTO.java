package com.Staffing_Planner.Staffing_Planner.dto;

import com.Staffing_Planner.Staffing_Planner.models.ShiftType;

import java.util.List;

public record AssignDTO(String date, ShiftType shift, List<String> employeeIds) {}
package com.Staffing_Planner.Staffing_Planner.dto;

import com.Staffing_Planner.Staffing_Planner.models.Employee;
import com.Staffing_Planner.Staffing_Planner.models.ShiftType;

import java.util.List;

public record ShiftScheduleDTO(ShiftType shift, List<String> employeeId) {}


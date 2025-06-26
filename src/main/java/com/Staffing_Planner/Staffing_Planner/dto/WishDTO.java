package com.Staffing_Planner.Staffing_Planner.dto;

import com.Staffing_Planner.Staffing_Planner.models.ShiftType;

import java.time.LocalDate;

public record WishDTO(String employeeId, LocalDate date, ShiftType shift) {}
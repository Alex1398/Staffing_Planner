package com.Staffing_Planner.Staffing_Planner.dto;

import com.Staffing_Planner.Staffing_Planner.models.ShiftType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record WishDTO(String employeeId,
                      @JsonFormat(pattern = "yyyy-MM-dd")LocalDate date,
                      ShiftType shift) {}
package com.Staffing_Planner.Staffing_Planner.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "assignments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Assignment {
    @Id
    private String id;
    private List<Employee> employees;
    private LocalDate date;
    private ShiftType shift;
}
package com.Staffing_Planner.Staffing_Planner.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Document(collection = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee {
    @Id
    private String id;
    private String name;
}
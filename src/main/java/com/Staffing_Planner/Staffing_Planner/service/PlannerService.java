package com.Staffing_Planner.Staffing_Planner.service;

import com.Staffing_Planner.Staffing_Planner.models.Assignment;
import com.Staffing_Planner.Staffing_Planner.models.Employee;
import com.Staffing_Planner.Staffing_Planner.models.ShiftType;
import com.Staffing_Planner.Staffing_Planner.models.WishEntry;
import com.Staffing_Planner.Staffing_Planner.repository.AssignmentRepository;
import com.Staffing_Planner.Staffing_Planner.repository.EmployeeRepository;
import com.Staffing_Planner.Staffing_Planner.repository.WishEntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlannerService {
    private final WishEntryRepository wishes;
    private final AssignmentRepository assignments;
    private final EmployeeRepository employees;

    public WishEntry addWish(String empId, LocalDate date, ShiftType shift) {
        Optional<Employee> emp = employees.findById(empId);
        WishEntry wish = new WishEntry();
        wish.setEmployeeId(empId);
        wish.setDate(date);
        wish.setShift(shift);
        return wishes.save(wish);
    }

    public List<WishEntry> listWishes(LocalDate date) {
        return (date == null) ? wishes.findAll() : wishes.findByDate(date);
    }

    public List<Assignment> assign(String date, ShiftType shift, List<String> empIds) {
        LocalDate d = LocalDate.parse(date);
        // enforce two per shift:
        if (empIds.size() != 2)
            throw new IllegalArgumentException("Must assign exactly two employees");
        // enforce one shift/day per employee:
        for (String id : empIds) {
            Optional<Employee> emp = employees.findById(id);

            if (assignments.existsByEmployeeIdAndDate(id, d))
                throw new IllegalStateException(emp.get().getName() + " already has a shift on " + date);
            Assignment a = new Assignment();
            a.setEmployeeId(id);
            a.setDate(d);
            a.setShift(shift);
            assignments.save(a);
        }
        return assignments.findByDate(d);
    }

    public Map<ShiftType, List<String>> getSchedule(LocalDate date) {
        return assignments.findByDate(date).stream()
                .collect(groupingBy(Assignment::getShift,
                        mapping(Assignment::getEmployeeId, toList())));
    }
}
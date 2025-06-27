package com.Staffing_Planner.Staffing_Planner.controller;

import com.Staffing_Planner.Staffing_Planner.dto.AssignDTO;
import com.Staffing_Planner.Staffing_Planner.dto.ShiftScheduleDTO;
import com.Staffing_Planner.Staffing_Planner.dto.WishDTO;
import com.Staffing_Planner.Staffing_Planner.models.Assignment;
import com.Staffing_Planner.Staffing_Planner.models.Employee;
import com.Staffing_Planner.Staffing_Planner.models.ShiftType;
import com.Staffing_Planner.Staffing_Planner.models.WishEntry;
import com.Staffing_Planner.Staffing_Planner.service.PlannerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PlannerController {
    private final PlannerService svc;

    public PlannerController(PlannerService svc) { this.svc = svc; }

    @PostMapping("/wishes")
    @ResponseStatus(HttpStatus.CREATED)
    public WishEntry postWish(@RequestBody @NotNull WishDTO dto) {
        return svc.addWish(dto.employeeId(), dto.date(), dto.shift());
    }

    @GetMapping("/wishes")
    public List<WishEntry> getWishes(@RequestParam(required=false) String date) {
        LocalDate d = date==null ? null : LocalDate.parse(date);
        return svc.listWishes(d);
    }

    @PostMapping("/assign")
    public List<Assignment> postAssign(@RequestBody AssignDTO dto) {
        return svc.assign(dto.date(), dto.shift(), dto.employeeIds());
    }

    @GetMapping("/schedule")
    public List<ShiftScheduleDTO> getSchedule(
            @RequestParam String date) {
        LocalDate d = LocalDate.parse(date);
        Map<ShiftType, List<Employee>> map = svc.getSchedule(d);
        return map.entrySet().stream()
                .map(e -> new ShiftScheduleDTO(e.getKey(), e.getValue()))
                .toList();
    }
}

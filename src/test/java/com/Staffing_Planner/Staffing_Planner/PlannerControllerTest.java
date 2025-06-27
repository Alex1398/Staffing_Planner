package com.Staffing_Planner.Staffing_Planner;

import com.Staffing_Planner.Staffing_Planner.controller.PlannerController;
import com.Staffing_Planner.Staffing_Planner.dto.AssignDTO;
import com.Staffing_Planner.Staffing_Planner.dto.WishDTO;
import com.Staffing_Planner.Staffing_Planner.models.Assignment;
import com.Staffing_Planner.Staffing_Planner.models.Employee;
import com.Staffing_Planner.Staffing_Planner.models.ShiftType;
import com.Staffing_Planner.Staffing_Planner.models.WishEntry;
import com.Staffing_Planner.Staffing_Planner.service.PlannerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlannerController.class)
class PlannerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlannerService plannerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postWish_createsAndReturnsWish() throws Exception {
        // Prepare DTO and stubbed return
        WishDTO dto = new WishDTO("emp1", LocalDate.of(2025,7,1), ShiftType.EARLY);
        WishEntry saved = new WishEntry();
        saved.setId("wish1");
        saved.setEmployeeId("emp1");
        saved.setDate(LocalDate.of(2025,7,1));
        saved.setShift(ShiftType.EARLY);

        when(plannerService.addWish("emp1", LocalDate.of(2025,7,1), ShiftType.EARLY))
                .thenReturn(saved);

        mockMvc.perform(post("/api/wishes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("wish1"))
                .andExpect(jsonPath("$.employeeId").value("emp1"))
                .andExpect(jsonPath("$.shift").value("EARLY"))
                .andExpect(jsonPath("$.date").value("2025-07-01"));
    }

    @Test
    void getWishes_returnsList() throws Exception {
        WishEntry w = new WishEntry();
        w.setId("w2");
        w.setEmployeeId("emp2");
        w.setDate(LocalDate.of(2025,7,2));
        w.setShift(ShiftType.LATE);

        when(plannerService.listWishes(null)).thenReturn(List.of(w));

        mockMvc.perform(get("/api/wishes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("w2"))
                .andExpect(jsonPath("$[0].shift").value("LATE"));
    }

    @Test
    void assign_returnsAssignments() throws Exception {
        Employee e1 = new Employee(); e1.setId("emp1"); e1.setName("Alice");
        Employee e2 = new Employee(); e1.setId("emp2"); e1.setName("Bob");
        List<Employee> employeeList = Arrays.asList(e1, e2);
        List<String> employeeListIds = Arrays.asList(e1.getId(), e2.getId());

        AssignDTO dto = new AssignDTO(LocalDate.of(2025, 5, 4), ShiftType.LATE, employeeListIds);
        Assignment a = new Assignment();
        a.setId("assign1");
        a.setEmployees(employeeList);
        a.setDate(LocalDate.of(2025,7,1));
        a.setShift(ShiftType.LATE);

        when(plannerService.assign(LocalDate.of(2025, 5, 4), ShiftType.LATE, employeeListIds))
                .thenReturn(List.of(a));

        mockMvc.perform(post("/api/assign")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value("assign1"));
    }

    @Test
    void getSchedule_returnsShiftScheduleList() throws Exception {
        // Prepare a dummy schedule map
        Employee e1 = new Employee(); e1.setId("emp1"); e1.setName("Alice");
        Employee e2 = new Employee(); e2.setId("emp2"); e2.setName("Bob");
        List<Employee> employeeListEarly = Arrays.asList(e1, e2);

        Employee e3 = new Employee(); e3.setId("emp3"); e3.setName("Josh");
        Employee e4 = new Employee(); e4.setId("emp4"); e4.setName("Sara");
        List<Employee> employeeListLate = Arrays.asList(e3, e4);

        Map<ShiftType,List<Employee>> schedule = new LinkedHashMap<>();
        schedule.put(ShiftType.EARLY, employeeListEarly);
        schedule.put(ShiftType.LATE,  employeeListLate);

        when(plannerService.getSchedule(LocalDate.of(2025,7,1)))
                .thenReturn(schedule);

        mockMvc.perform(get("/api/schedule")
                        .param("date","2025-07-01"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.shift=='EARLY')].employee[0].name").value("Alice"))
                .andExpect(jsonPath("$[?(@.shift=='LATE')].employee[1].name").value("Sara"));
    }
}

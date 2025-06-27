package com.Staffing_Planner.Staffing_Planner;

import com.Staffing_Planner.Staffing_Planner.models.Employee;
import com.Staffing_Planner.Staffing_Planner.models.ShiftType;
import com.Staffing_Planner.Staffing_Planner.models.WishEntry;
import com.Staffing_Planner.Staffing_Planner.models.Assignment;
import com.Staffing_Planner.Staffing_Planner.repository.AssignmentRepository;
import com.Staffing_Planner.Staffing_Planner.repository.EmployeeRepository;
import com.Staffing_Planner.Staffing_Planner.repository.WishEntryRepository;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class StaffingPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffingPlannerApplication.class, args);
	}

//		@Bean
//	public CommandLineRunner loadData(EmployeeRepository employeeRepo, WishEntryRepository wishRepo, AssignmentRepository assignRepo) {
//		return args -> {
//			// 1) Create some employees
//			Employee alice = new Employee();
//			alice.setName("Alice");
//			alice = employeeRepo.save(alice);
//
//			Employee bob = new Employee();
//			bob.setName("Bob");
//			bob = employeeRepo.save(bob);
//
//			Employee carol = new Employee();
//			carol.setName("Carol");
//			carol = employeeRepo.save(carol);
//
//			// 2) Add some wishes
//			LocalDate today = LocalDate.now();
//			WishEntry w1 = new WishEntry();
//			w1.setEmployeeId(alice.getId());
//			w1.setDate(today.plusDays(1));
//			w1.setShift(ShiftType.EARLY);
//			wishRepo.save(w1);
//
//			WishEntry w2 = new WishEntry();
//			w2.setEmployeeId(bob.getId());
//			w2.setDate(today.plusDays(1));
//			w2.setShift(ShiftType.LATE);
//			wishRepo.save(w2);
//
//			WishEntry w3 = new WishEntry();
//			w3.setEmployeeId(carol.getId());
//			w3.setDate(today.plusDays(2));
//			w3.setShift(ShiftType.EARLY);
//			wishRepo.save(w3);
//
//			// 3) Make an assignment for tomorrow’s early shift
//			Assignment a1 = new Assignment();
//			a1.setEmployeeId(alice.getId());
//			a1.setDate(today.plusDays(1));
//			a1.setShift(ShiftType.EARLY);
//			assignRepo.save(a1);
//
//			Assignment a2 = new Assignment();
//			a2.setEmployeeId(bob.getId());
//			a2.setDate(today.plusDays(1));
//			a2.setShift(ShiftType.EARLY);
//			assignRepo.save(a2);
//
//			System.out.println("🌱 Loaded dummy employees, wishes, and assignments");
//		};
//	}

}

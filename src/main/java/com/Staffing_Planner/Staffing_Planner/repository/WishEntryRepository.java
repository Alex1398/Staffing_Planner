package com.Staffing_Planner.Staffing_Planner.repository;

import com.Staffing_Planner.Staffing_Planner.models.WishEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WishEntryRepository extends MongoRepository<WishEntry, String> {
    List<WishEntry> findByDate(LocalDate date);
    Optional<WishEntry> findByEmployeeIdAndDate(String employeeId, LocalDate date);
}
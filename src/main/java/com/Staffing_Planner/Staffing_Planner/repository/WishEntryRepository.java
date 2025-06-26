package com.Staffing_Planner.Staffing_Planner.repository;

import com.Staffing_Planner.Staffing_Planner.models.WishEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;
import java.util.List;

public interface WishEntryRepository extends MongoRepository<WishEntry, String> {
    List<WishEntry> findByDate(LocalDate date);
}
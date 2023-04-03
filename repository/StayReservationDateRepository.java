package com.zz.staybooking.repository;

import com.zz.staybooking.model.Stay;
import com.zz.staybooking.model.StayReservedDate;
import com.zz.staybooking.model.StayReservedDateKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface StayReservationDateRepository extends JpaRepository<StayReservedDate, StayReservedDateKey> {
    @Query(value = "SELECT srd.id.stay_id FROM StayReservedDate srd WHERE srd.id.stay_id IN ?1 AND srd.id.date BETWEEN ?2 AND ?3 GROUP BY srd.id.stay_id")
    Set<Long> findByIdInAndDateBetween(List<Long> stayIds, LocalDate startDate, LocalDate endDate);

    List<StayReservedDate> findByStay(Stay stay);
}

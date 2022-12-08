package com.ra.trainBooking.repository;

import com.ra.trainBooking.model.TrainData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainDataRepository  extends JpaRepository<TrainData, Integer> {
    @Query(value = "select * from Reservation  where reservation.to_destination =:to and reservation.from_destination =:from and reservation.filter_date =:date  order By reservation.filter_date desc " , nativeQuery = true)
    List<TrainData> findByToFromAndDate(String to , String from, String date);
}

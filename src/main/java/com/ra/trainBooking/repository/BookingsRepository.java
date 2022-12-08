package com.ra.trainBooking.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ra.trainBooking.model.Bookings;
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {
	List<Bookings> findByUserId(int userId);
	
}

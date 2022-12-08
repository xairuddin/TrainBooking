package com.ra.trainBooking.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ra.trainBooking.DTO.BookingsDTO;
import com.ra.trainBooking.DTO.UserRegisteredDTO;
import com.ra.trainBooking.model.Bookings;
import com.ra.trainBooking.model.User;

public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);

	Bookings updateBookings(BookingsDTO bookingDTO,UserDetails user);
	
	void sendEmail(BookingsDTO bookingDTO, User users, String nameGenrator);


}

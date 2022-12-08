package com.ra.trainBooking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ra.trainBooking.DTO.BookingsDTO;
import com.ra.trainBooking.DTO.ReservationDTO;
import com.ra.trainBooking.helper.ObjectCreationHelper;
import com.ra.trainBooking.model.Bookings;
import com.ra.trainBooking.model.TrainData;
import com.ra.trainBooking.model.User;
import com.ra.trainBooking.repository.BookingsRepository;
import com.ra.trainBooking.repository.TrainDataRepository;
import com.ra.trainBooking.repository.UserRepository;
import com.ra.trainBooking.service.DefaultUserService;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	 private DefaultUserService userService;

	    public DashboardController(DefaultUserService userService) {
	        super();
	        this.userService = userService;
	    }
	
	@Autowired
	BookingsRepository bookingsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TrainDataRepository trainDataRepository;

	@ModelAttribute("reservation")
    public ReservationDTO reservationDTO() {
        return new ReservationDTO();
    }
	
	@GetMapping
    public String displayDashboard(Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "dashboard";
    }
	
	@PostMapping
	public String filterTrainData( @ModelAttribute("reservation") ReservationDTO reservationDTO , Model model) {
		List<TrainData> trainData = trainDataRepository.findByToFromAndDate(reservationDTO.getTo(), reservationDTO.getFrom(), reservationDTO.getFilterDate());
		
		
		if(trainData.isEmpty()) {
			trainData = null;
		}
		String user = returnUsername();
        model.addAttribute("userDetails", user);
		
		model.addAttribute("trainData",trainData);
		model.addAttribute("reservation", reservationDTO);
	    return "dashboard";
	}
	@GetMapping("/book/{id}")
	public String bookPage(@PathVariable int id,Model model) {
		Optional<TrainData> trainData = trainDataRepository.findById(id);
		BookingsDTO bks = ObjectCreationHelper.createBookingsDTO(trainData.get());
		
		String user = returnUsername();
        model.addAttribute("userDetails", user);
         
		model.addAttribute("record", bks);
	return "book";	
	}
	
	@PostMapping("/booking")
	public String finalBooking(@ModelAttribute("record") BookingsDTO bookingDTO,Model model) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		Bookings b = userService.updateBookings(bookingDTO,user);
		model.addAttribute("record", new BookingsDTO());
		return "redirect:/myBooking";	
	}
	
	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		return users.getName();
	}
	
}

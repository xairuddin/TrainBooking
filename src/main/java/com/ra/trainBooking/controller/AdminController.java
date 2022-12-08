package com.ra.trainBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ra.trainBooking.DTO.BookingsDTO;
import com.ra.trainBooking.model.TrainData;
import com.ra.trainBooking.model.User;
import com.ra.trainBooking.repository.TrainDataRepository;
import com.ra.trainBooking.repository.UserRepository;

@Controller
@RequestMapping("/adminScreen")
public class AdminController {
	@Autowired
	UserRepository userRepository;
	@Autowired 
	TrainDataRepository trainDataRepository;
	@ModelAttribute("trainDetails")
    public TrainData trainData() {
        return new TrainData();
    }
	@GetMapping
    public String displayDashboard(Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "adminScreen";
    }
	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		return users.getName();
	}
	@PostMapping
    public String saveTrainData(@ModelAttribute("trainDetails") TrainData trainData,Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        trainDataRepository.save(trainData);
        model.addAttribute("trainDetails", new TrainData());
        return "redirect:/adminScreen?success";
    }
}

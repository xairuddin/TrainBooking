package com.ra.trainBooking.controller;

import com.ra.trainBooking.DTO.UserLoginDTO;
import com.ra.trainBooking.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.ra.trainBooking.DTO.UserRegisteredDTO;
import com.ra.trainBooking.service.DefaultUserService;

import java.util.Map;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	private final AuthenticationManager authenticationManager;

	 private DefaultUserService userService;
	 @Autowired
	 private JWTUtil jwtUtil;

	 	@Autowired
	    public RegistrationController(AuthenticationManager authenticationManager, DefaultUserService userService) {
	        super();
			this.authenticationManager = authenticationManager;
			this.userService = userService;
		}

	    @ModelAttribute("user")
	    public UserRegisteredDTO userRegistrationDto() {
	        return new UserRegisteredDTO();
	    }

	    @GetMapping
	    public String showRegistrationForm() {
	        return "register";
	    }

//	    @PostMapping
//	    public String registerUserAccount(@ModelAttribute("user")
//	              UserRegisteredDTO registrationDto) {
//	        userService.save(registrationDto);
//	        return "redirect:/login";
//	    }
		@PostMapping("/signup")
		public Map<String, String> registerUserAccount(@RequestBody
										  UserRegisteredDTO registrationDto) {
			System.out.println(registrationDto.getName());
			userService.save(registrationDto);
			System.out.println("ok");
			String token = jwtUtil.generateToken(registrationDto.getName());
			System.out.println(token);
			return Map.of("jwt-token", token);
		}
		@PostMapping("/login")
		public  Map<String, String> performLogin(@RequestBody UserLoginDTO userLoginDTO) {
			UsernamePasswordAuthenticationToken authInputToken =
					new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(),userLoginDTO.getPassword());
			try {
				authenticationManager.authenticate(authInputToken);
			}catch (BadCredentialsException exception) {
				return Map.of("message", "Incorrect credentials!");
			}

			String token = jwtUtil.generateToken(userLoginDTO.getUsername());
			return Map.of("jwt-token", token);
		}
}

package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.service.SongService;
import com.kodnest.tunehub.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService usersService;

	@Autowired
	SongService songService;

	@PostMapping("/register")
	 public String addUser(@ModelAttribute User user) {
		
		//email taken from registration form 
		String email = user.getEmail();
		
		//checking if the email as entered in registration form is present in DB or not.
	boolean status = usersService.emailExists(email);
	
	if(status == false) {
		usersService.addUser(user);
		System.out.println("User added");
	}
	else {
		System.out.println("User already exists");
	}
		 return "Login";
	
	 }
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session ,Model model) {
		
		if(usersService.validateUser(email,password)== true){
			
			String role =usersService.getRole(email);
			session.setAttribute("email", email);
			
			if(role.equals("admin")) {
				return "AdminHome";
			}else {
				
				User user = usersService.getUser(email);
				boolean userstatus = user.isIspremium();
				
				//fetching the song from songservice interface
				List<Song> songList = songService.fetchAllSongs();
	            model.addAttribute("songs", songList);
				
				model.addAttribute("ispremium", userstatus);
				
				return "customerHome";
			}
//		return "home";
		}
		else {
			return "login";
		}
	}
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "Login";
			
		}
	
	}
	


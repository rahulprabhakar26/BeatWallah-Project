package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodnest.tunehub.service.PlayListService;

@Controller
public class PlaylistController{
	
	
	@Autowired
	PlayListService playlistService;
	
	
	@GetMapping("/get")
	public String updatePlaylist(Model model) {
		model.addAttribute("songs", playlistService.updatePlaylistName());
		return "home";
	}
	
}

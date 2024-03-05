package com.kodnest.tunehub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;

@Service
public interface SongService {

	public String addSongs(Song song);

	public boolean nameExists(String name);

	//public List<Song> viewSong();

	public List<Song> fetchAllSongs();

	public void updateSong(Song s);

	

	//public boolean linkExists(String link);



}
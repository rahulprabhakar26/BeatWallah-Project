package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService {
	
	@Autowired
	SongRepository songRepo;

	@Override
	public String addSongs(Song song) {
	    songRepo.save(song);
		return "song Addedd";
	}

	@Override
	public boolean nameExists(String name) {
		if(songRepo.findByName(name)!=null) {
			return true;
		}else {
		return false;
	}
	}

	@Override
	public List<Song> fetchAllSongs() {
		   List<Song> songs = songRepo.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song s) {
		songRepo.save(s);
		
	}
	
	
//
//	@Override
//	public List<Song> viewSong() {
//    List<Song> al= songRepo.findAll();
//		System.out.println(al);
//		return al;
//	}

//	@Override
//	public boolean linkExists(String link) {
//		
//		if(songRepo.findByLink(link)!=null) {
//			return true;
//		}
//		else {
//		return false;
//	}
}


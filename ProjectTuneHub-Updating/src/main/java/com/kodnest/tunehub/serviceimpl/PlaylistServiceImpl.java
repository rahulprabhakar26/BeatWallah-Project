package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.repository.PlaylistRepository;
import com.kodnest.tunehub.service.PlayListService;

@Service
public class PlaylistServiceImpl implements PlayListService {

    

    @Autowired
    PlaylistRepository playlistRepository;
    

	@Override
	public List<PlayList> updatePlaylistName() {
	
		return playlistRepository.findAll();
	}

//    @Override
//    public PlayList updatePlaylistName(Long id, String newName) {
//        PlayList playlist = playlistRepository.findById(id);
//               // .orElseThrow(() -> new IllegalArgumentException("Invalid playlist Id:" + id));
//        playlist.setName(newName);
//        return playlistRepository.save(playlist);
//    }
}

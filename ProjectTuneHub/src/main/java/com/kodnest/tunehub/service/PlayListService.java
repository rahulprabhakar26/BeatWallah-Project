package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.PlayList;

public interface PlayListService {

	public void addplaylist(PlayList playlist);

	

	public List<PlayList> fetchAllPlayList();



	public List<PlayList> fetchAllPlayLists();



	//public PlayList updatePlaylistName(Integer id, String newName);



	public String updateplayList(Integer id, String name);




	

}

package com.kodnest.tunehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodnest.tunehub.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

	 public Song findByName(String name);

	public List<Song> findAll();

	//public Song findByLink(String link);

}

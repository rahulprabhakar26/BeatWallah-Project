package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehub.entity.PlayList;

public interface PlaylistRepository extends JpaRepository<PlayList, Integer> {

	PlayList findById(Long id);

	PlayList save(PlayList playlist);

}

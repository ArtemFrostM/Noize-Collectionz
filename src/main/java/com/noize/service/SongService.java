package com.noize.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.noize.entity.Song;

public interface SongService {
	void saveSong(Song song);
	
	List<Song> showAllSongs();
	
	void deleteSong(int id);
	
	Song findSongById(int id);
}

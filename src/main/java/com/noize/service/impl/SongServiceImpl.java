package com.noize.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noize.entity.Song;
import com.noize.repository.SongRepository;
import com.noize.service.SongService;

@Service
public class SongServiceImpl implements SongService{
	
	@Autowired
	private SongRepository repository;

	@Override
	public void saveSong(Song song) {
		repository.save(song);
	}

	@Override
	public List<Song> showAllSongs() {
		return repository.findAll();
	}

	@Override
	public Song findSongById(int id) {
		return repository.findOne(id);
	}

	@Override
	public void deleteSong(int id) {
		repository.delete(id);
	}

}

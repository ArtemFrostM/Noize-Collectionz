package com.noize.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.noize.domain.ArtistNameFilter;
import com.noize.entity.Artist;

public interface ArtistService {
	void saveArtist(Artist artist);
	
	List<Artist> showAllArtists();
	
	Artist findArtistById(int id);
	
	void deleteArtist(int id);
	
//	List<Artist> showRapArtists();
	
	Page<Artist> findArtistsByName(Pageable pageable, ArtistNameFilter filter);
}

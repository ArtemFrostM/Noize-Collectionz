package com.noize.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.noize.domain.AlbumTitleFilter;
import com.noize.entity.Album;

public interface AlbumService {
	void saveAlbum(Album album);
	
	List<Album> showAlbums();
	
	Album findAlbumById(int id);
	
	void deleteAlbum(int id);
	
	Page<Album> findAllAlbumsByTitle(Pageable pageable, AlbumTitleFilter filter);
}

package com.noize.mapper;

import com.noize.domain.CreateSongRequest;
import com.noize.domain.EditSongRequest;
import com.noize.domain.SongProfileRequest;
import com.noize.entity.Song;

public interface SongMapper {
	
	//SHOW SONG PROFILE
	public static SongProfileRequest entityToSongProfile(Song song) {
		SongProfileRequest request = new SongProfileRequest();
		request.setId(song.getId());
		request.setName(song.getName());
		request.setAlbum(song.getAlbum());
		request.setArtists(song.getArtists());
		
		return request;
	}
	
	//CREATE SONG
	public static Song createRequestToSong(CreateSongRequest request) {
		Song song = new Song();
		song.setName(request.getName());
		song.setArtists(request.getArtists());
		song.setAlbum(request.getAlbum());
		
		return song;
	}
	
	public static CreateSongRequest entityToCreateSong(Song song) {
		CreateSongRequest request = new CreateSongRequest();
		request.setName(song.getName());
		request.setAlbum(song.getAlbum());
		request.setArtists(song.getArtists());
		
		return request;
	}
	
	//EDIT SONG
	public static EditSongRequest songToEditDomain(Song song) {
		EditSongRequest request = new EditSongRequest();
		request.setAlbum(song.getAlbum());
		request.setArtists(song.getArtists());
		request.setName(song.getName());
		request.setEntity(song.getEntity());
		request.setId(song.getId());
		
		
		return request;
	}
	
	public static Song addRequestToSong(EditSongRequest request) {
		Song song = new Song();
		//song.setAlbum(request.getAlbum());
		song.setArtists(request.getArtists());
		song.setName(request.getName());
		song.setEntity(request.getEntity());
		
		return song;
	}
	
	
}

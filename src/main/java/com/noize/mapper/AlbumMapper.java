package com.noize.mapper;

import com.noize.domain.AddUserToAlbumRequest;
import com.noize.domain.AlbumProfileRequest;
import com.noize.domain.CreateAlbumRequest;
import com.noize.domain.CreateAlbumRequestInArtist;
import com.noize.domain.EditAlbumImage;
import com.noize.domain.EditAlbumRequest;
import com.noize.entity.Album;

public interface AlbumMapper {
	//CREATE
	public static Album createRequestToAlbum(CreateAlbumRequest request) {
		Album album = new Album();
		album.setTitle(request.getTitle());
		album.setYear(request.getYear());
		album.setGenre(request.getGenre());
		album.setAlbumImage(request.getFile().getOriginalFilename());
		album.setArtist(request.getArtist());
		album.setAlbumType(request.getAlbumType());
		
		return album;
	}
	//CREATE IN ARTIST
	public static Album createRequestToAlbumInArtist(CreateAlbumRequestInArtist request) {
		Album album = new Album();
		album.setTitle(request.getTitle());
		album.setYear(request.getYear());
		album.setGenre(request.getGenre());
		album.setAlbumImage(request.getFile().getOriginalFilename());
		album.setArtist(request.getArtist());
		album.setAlbumType(request.getAlbumType());
		
		return album;
	}
	
	public static CreateAlbumRequestInArtist entityToCreateAlbum(Album album) {
		CreateAlbumRequestInArtist request = new CreateAlbumRequestInArtist();
		request.setTitle(album.getTitle());
		request.setYear(album.getYear());
		request.setGenre(album.getGenre());
		request.setArtist(album.getArtist());
		request.setAlbumType(album.getAlbumType());
		
		return request;
		
	}
	//SHOW PROFILE
	public static AlbumProfileRequest entityToArtistProfile(Album album) {
		AlbumProfileRequest request = new AlbumProfileRequest();
		request.setTitle(album.getTitle());
		request.setYear(album.getYear());
		request.setGenre(album.getGenre());
		request.setAlbumType(album.getAlbumType());
		request.setArtist(album.getArtist());
		request.setId(album.getId());
		request.setSongs(album.getSongs());
		
		return request;
		
	}
	
	//EDIT ALBUM
	public static EditAlbumRequest albumToEditDomain(Album album) {
		EditAlbumRequest request = new EditAlbumRequest();
		request.setId(album.getId());
		request.setAlbumType(album.getAlbumType());
		request.setArtist(album.getArtist());
		request.setGenre(request.getGenre());
		request.setSongs(album.getSongs());
		request.setTitle(album.getTitle());
		request.setYear(album.getYear());
		request.setUsers(album.getUsers());
		
		
		return request;
	}
	
	public static Album editRequestToAlbum(EditAlbumRequest request) {
		Album album = new Album();
		album.setId(request.getId());
		album.setAlbumType(request.getAlbumType());
		album.setArtist(request.getArtist());
		album.setGenre(request.getGenre());
		album.setSongs(request.getSongs());
		album.setTitle(request.getTitle());
		album.setYear(request.getYear());
		album.setUsers(request.getUsers());
		album.setAlbumImage(request.getFile().getOriginalFilename());
		
		return album;
	}
	
	//EDIT ALBUM IMAGE
		public static EditAlbumImage albumToEditImageDomain(Album album) {
			EditAlbumImage request = new EditAlbumImage();
			request.setId(album.getId());
			
			return request;
		}
		
		public static Album editImageRequestToAlbum(EditAlbumImage request) {
			Album album = new Album();
			album.setId(request.getId());
			album.setAlbumImage(request.getFile().getOriginalFilename());
			
			return album;
		}
	
	//ADD FOLLOWER
	public static Album addAlbumToUser(AddUserToAlbumRequest request) {
		Album album = new Album();
		//album.setAlbumImage(request.getFile().getOriginalFilename());
		//album.setGenre(request.getGenre());
		album.setId(request.getId());
		//album.setTitle(request.getTitle());
		album.setUsers(request.getUsers());
		
		return album;
	}
	
	public static AddUserToAlbumRequest addEntityToAlbumUser(Album album) {
		AddUserToAlbumRequest request = new AddUserToAlbumRequest();
		request.setId(album.getId());
		request.setUsers(album.getUsers());
		
		return request;
	}
	
	//public static AddUserToAlbumRequest 

}

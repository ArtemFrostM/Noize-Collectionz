package com.noize.mapper;

import com.noize.domain.ArtistProfileRequest;
import com.noize.domain.CreateArtistRequest;
import com.noize.domain.EditArtistImageRequest;
import com.noize.domain.EditArtistRequest;
import com.noize.entity.Artist;
import com.noize.service.utils.CustomFileUtils;

public class ArtistMapper {
	
	public static Artist createRequestToArtist(CreateArtistRequest requsest) {
		Artist artist = new Artist();
		artist.setName(requsest.getName());
		artist.setDescription(requsest.getDescription());
		artist.setGenre(requsest.getGenre());
		artist.setArtistImage(requsest.getFile().getOriginalFilename());
		
		
		return artist;
	}
	
	public static ArtistProfileRequest entityToArtistProfile(Artist artist) {
		ArtistProfileRequest request = new ArtistProfileRequest();
		request.setName(artist.getName());
		request.setDescription(artist.getDescription());
		request.setGenre(artist.getGenre());
		request.setId(artist.getId());
		request.setAlbums(artist.getAlbums());
		//request.setFile();
		
		return request;
	}
	
	//EDIT ARTIST
	public static EditArtistRequest artistToEditDomain(Artist artist) {
		EditArtistRequest request = new EditArtistRequest();
		request.setId(artist.getId());
		request.setAlbums(artist.getAlbums());
		request.setDescription(artist.getDescription());
		request.setName(artist.getName());
		request.setGenre(artist.getGenre());
		request.setSongs(artist.getSongs());
		request.setUsers(artist.getUsers());
		
		return request;
	}
	
	public static Artist editRequestToArtist(EditArtistRequest request) {
		Artist artist = new Artist();
		//artist.setId(request.getId());
		artist.setAlbums(request.getAlbums());
		artist.setDescription(request.getDescription());
		artist.setName(request.getName());
		artist.setGenre(request.getGenre());
		artist.setSongs(request.getSongs());
		artist.setUsers(request.getUsers());
		
		return artist;
	}
	
	//EDIT ARTIST
		public static EditArtistImageRequest artistToEditImageDomain(Artist artist) {
			EditArtistImageRequest request = new EditArtistImageRequest();
			request.setId(artist.getId());
			
			return request;
		}
		
		public static Artist editImageRequestToArtist(EditArtistImageRequest request) {
			Artist artist = new Artist();
			artist.setId(request.getId());
			artist.setArtistImage(request.getFile().getOriginalFilename());
			
			return artist;
		}
}

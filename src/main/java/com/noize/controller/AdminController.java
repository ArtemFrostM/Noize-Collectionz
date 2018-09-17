package com.noize.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noize.domain.CreateAlbumRequest;
import com.noize.domain.CreateArtistRequest;
import com.noize.entity.Album;
import com.noize.entity.Artist;
import com.noize.entity.enumeration.Genre;
import com.noize.mapper.AlbumMapper;
import com.noize.mapper.ArtistMapper;
import com.noize.service.AlbumService;
import com.noize.service.ArtistService;
import com.noize.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired ArtistService artService;
	@Autowired AlbumService albService;
	
	@GetMapping("/create_artist")
	public String createArtist(Model model) {
		
		model.addAttribute("artistModel", new CreateArtistRequest());
		model.addAttribute("genres", Genre.values());
		return "admin/addartist";
	}
	
	@PostMapping("/create_artist")
	public String saveArtist(@ModelAttribute("artistModel") CreateArtistRequest request) throws IOException {
		
		Artist artist = ArtistMapper.createRequestToArtist(request);
		artService.saveArtist(artist);
		
		CustomFileUtils.createFolder("artist_" + artist.getId());
		CustomFileUtils.createImage("artist_" + artist.getId(), request.getFile());
		
		
		return "redirect:/";
	}
	
//	WORKING CREATE ALBUM
//	@GetMapping("/create_album")
//	public String createAlbum(Model model) {
//		
//		model.addAttribute("albumModel", new CreateAlbumRequest());
//		model.addAttribute("genresA", Genre.values());
//		return "admin/addalbum";
//	}
//	
//	@PostMapping("/create_album")
//	public String saveAlbum(@ModelAttribute("albumModel") CreateAlbumRequest request) throws IOException {
//		
//		Album album = AlbumMapper.createRequestToAlbum(request);
//		albService.saveAlbum(album);
//		
//		CustomFileUtils.createFolder("album_" + album.getId());
//		CustomFileUtils.createImage("album_" + album.getId(), request.getFile());
//		
//		
//		return "redirect:/";
//	}
	
	@GetMapping("/create_album")
	public String createAlbum(Model model) {
		//List<Artist> artists = artService.showAllArtists();
		model.addAttribute("albumModel", new CreateAlbumRequest());
		model.addAttribute("artistsN",artService.showAllArtists()); //artists);
		model.addAttribute("genresA", Genre.values());
		return "admin/addalbum";
	}
	
	@PostMapping("/create_album")
	public String saveAlbum(@ModelAttribute("albumModel") CreateAlbumRequest request) throws IOException {
		
		Album album = AlbumMapper.createRequestToAlbum(request);
		albService.saveAlbum(album);
		
		CustomFileUtils.createFolder("album_" + album.getId());
		CustomFileUtils.createImage("album_" + album.getId(), request.getFile());
		
		
		return "redirect:/";
	}
}

package com.noize.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.noize.domain.LoginRequest;
import com.noize.domain.RegisterRequest;
import com.noize.mapper.UserMapper;
import com.noize.service.UserService;
import com.noize.service.utils.CustomFileUtils;

@Controller
public class BaseController {
	
	@Autowired private UserService userService;
	
	@GetMapping({"/", "/home"})
	public String shoHome(Model model) throws IOException {
		model.addAttribute("artistPic", CustomFileUtils.getImage("standart", "artist.jpg"));
		model.addAttribute("albumPic", CustomFileUtils.getImage("standart", "album.jpg"));
		model.addAttribute("songPic", CustomFileUtils.getImage("standart", "song.png"));
		
		return "home";
	}
	
	@GetMapping("/artists")
	public String shoArtists(Model model) throws IOException {
		model.addAttribute("artistPic", CustomFileUtils.getImage("standart", "artist.jpg"));
		model.addAttribute("top30", CustomFileUtils.getImage("standart", "top-30.png"));
		model.addAttribute("genre", CustomFileUtils.getImage("standart", "ar-genres.jpg"));
		return "artists";
	}
	
	@GetMapping("/albums")
	public String shoAlbums(Model model) throws IOException {
		model.addAttribute("list", CustomFileUtils.getImage("standart", "album.jpg"));
		model.addAttribute("top", CustomFileUtils.getImage("standart", "purple.jpg"));
		model.addAttribute("genre", CustomFileUtils.getImage("standart", "green.jpg"));
		model.addAttribute("type", CustomFileUtils.getImage("standart", "pink.jpg"));
		model.addAttribute("year", CustomFileUtils.getImage("standart", "blue.jpg"));
		return "albums";
	}
	
	@GetMapping("/songs")
	public String shoSongs() {
		return "songs";
	}
	
	@GetMapping("/artists_genres")
	public String shoArtistsGenres(Model model) throws IOException {
		model.addAttribute("artistRockPic", CustomFileUtils.getImage("standart", "rock-logo.jpg"));
		model.addAttribute("artistTrapPic", CustomFileUtils.getImage("standart", "trap-logo.png"));
		model.addAttribute("artistHousePic", CustomFileUtils.getImage("standart", "house-logo.jpeg"));
		model.addAttribute("artistRapPic", CustomFileUtils.getImage("standart", "rap-logo.jpg"));
		model.addAttribute("artistPopPic", CustomFileUtils.getImage("standart", "pop-logo.jpg"));
		model.addAttribute("artistDiscoPic", CustomFileUtils.getImage("standart", "disco-logo.jpg"));
		model.addAttribute("artistAlternativePic", CustomFileUtils.getImage("standart", "alternative-logo.jpg"));
		
		return "artistsgenres";
	}
	
	@GetMapping("/albums_genres")
	public String shoAlbumsGenres(Model model) throws IOException {
		model.addAttribute("artistRockPic", CustomFileUtils.getImage("standart", "rock-logo.jpg"));
		model.addAttribute("artistTrapPic", CustomFileUtils.getImage("standart", "trap-logo.png"));
		model.addAttribute("artistHousePic", CustomFileUtils.getImage("standart", "house-logo.jpeg"));
		model.addAttribute("artistRapPic", CustomFileUtils.getImage("standart", "rap-logo.jpg"));
		model.addAttribute("artistPopPic", CustomFileUtils.getImage("standart", "pop-logo.jpg"));
		model.addAttribute("artistDiscoPic", CustomFileUtils.getImage("standart", "disco-logo.jpg"));
		model.addAttribute("artistAlternativePic", CustomFileUtils.getImage("standart", "alternative-logo.jpg"));
		return "albumsgenres";
	}
	
	@GetMapping("/albums_year")
	public String showAlbumsYears(Model model) throws IOException {
		model.addAttribute("a90", CustomFileUtils.getImage("standart", "90.jpg"));
		model.addAttribute("a2000", CustomFileUtils.getImage("standart", "2000.jpg"));
		model.addAttribute("a18", CustomFileUtils.getImage("standart", "18.jpg"));
		return "albumsyears";
	}
	
	@GetMapping("/albums_types")
	public String showAlbumsTypes(Model model) throws IOException {
		model.addAttribute("lp", CustomFileUtils.getImage("standart", "album.jpg"));
		model.addAttribute("ep", CustomFileUtils.getImage("standart", "purple.jpg"));
		model.addAttribute("mixtype", CustomFileUtils.getImage("standart", "green.jpg"));
		model.addAttribute("single", CustomFileUtils.getImage("standart", "pink.jpg"));
		model.addAttribute("remix", CustomFileUtils.getImage("standart", "blue.jpg"));
		return "albumstypes";
	}
	
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new RegisterRequest());
		return "register";
	}
	
	@PostMapping("/register")
	public String createUser(@ModelAttribute("registerModel") @Valid RegisterRequest request, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "register";
		}
		
		userService.saveUser(UserMapper.registerToUser(request));
		
		return "redirect:/login";
	}
		
}

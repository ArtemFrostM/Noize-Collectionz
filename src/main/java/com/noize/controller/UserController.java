package com.noize.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.noize.domain.AddUserToAlbumRequestTwo;
import com.noize.domain.AddUserToArtistRequest;
import com.noize.domain.AddUserToSongRequest;
import com.noize.domain.EditImage;
import com.noize.domain.EditUserRequest;
import com.noize.domain.UserProfileRequest;
import com.noize.entity.Album;
import com.noize.entity.UserEntity;
import com.noize.mapper.UserMapper;
import com.noize.service.AlbumService;
import com.noize.service.ArtistService;
import com.noize.service.SongService;
import com.noize.service.UserService;
import com.noize.service.utils.CustomFileUtils;

@Controller
@RequestMapping({ "/user", "/admin" })
@SessionAttributes("editModel")
public class UserController {

	@Autowired
	private UserService service;
	@Autowired
	private AlbumService albumSer;
	@Autowired
	private SongService songService;
	@Autowired
	private ArtistService artistService;

	@GetMapping
	public String showUserProfile(Model model, Principal principal) throws IOException {
		System.out.println("Secured user name: " + principal.getName());
		UserEntity entity = service.findUserByEmail(principal.getName());

		if (entity == null) {
			return "redirect:/";
		}

		model.addAttribute("userProfile", UserMapper.entityToUserProfile(entity));
		model.addAttribute("imageSrc", CustomFileUtils.getImage("user_" + entity.getId(), entity.getImagePath()));
		return "user/profile";
	}

	@GetMapping("/edit/{userId}")
	public String editUserProfile(@PathVariable("userId") int userId, Model model, Principal principal) {

		UserEntity entity = service.findUserByEmail(principal.getName());

		if (userId != entity.getId())
			return "redirect:/user";
		EditUserRequest request = UserMapper.entityToEditUser(entity);
		List<Integer> years = new ArrayList<>();
		for(int i=6; i<=120; i++) {
			years.add(i);
		}
		
		model.addAttribute("yearsModel", years);
		model.addAttribute("editModel", request);

		return "user/edit";
	}

	@PostMapping("/edit/{userId}")
	public String saveEditedProfile(@ModelAttribute("editModel") EditUserRequest request,
			@PathVariable("userId") int userId, Principal principal) throws IOException {
		UserEntity entityTwo = service.findUserByEmail(principal.getName());
		// if(request.getFile().isEmpty()) {
		// return "redirect:/home";
		// }
		//UserEntity entity = UserMapper.editRequestToEntity(request);
		entityTwo.setAge(request.getAge());
		entityTwo.setFirstName(request.getFirstName());
		entityTwo.setLastName(request.getLastName());
		entityTwo.setNickname(request.getNickname());
		service.editUser(entityTwo);
		CustomFileUtils.createFolder("user_" + entityTwo.getId());
		// CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
		return "redirect:/user";
	}

	// EDIT IMAGE
	@GetMapping("/editImg/{userId}")
	public String editImage(@PathVariable("userId") int userId, Principal principal, Model model) {
		UserEntity entity = service.findUserByEmail(principal.getName());

		if (userId != entity.getId())
			return "redirect:/user";

		EditImage request = UserMapper.entityToEditImage(entity);
		model.addAttribute("editImgModel", request);

		return "user/editImg";
	}

	// @PostMapping("/editImg/{userId}")
	// public String saveEditedImage (@PathVariable("userId") int userId,
	// @ModelAttribute("editImgModel") EditImage request) throws IOException {
	// if (request.getFile().isEmpty()) {
	// return "redirect:/";
	// }
	// UserEntity entity = UserMapper.editImageRequestToEntity(request);
	// service.editUser(entity);
	// CustomFileUtils.createFolder("user_" + entity.getId());
	// CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
	//
	// return "redirect:/user";
	// }
	@PostMapping("/editImg/{userId}")
	public String saveImage(@ModelAttribute("editImgModel") EditImage request, Principal principal) throws IOException {
		UserEntity entity = service.findUserByEmail(principal.getName());
		// entity = UserMapper.editImageRequestToEntity(request);
		entity.setImagePath(request.getFile().getOriginalFilename());
		CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
		service.editUser(entity);

		return "redirect:/user";
	}

	// ADD ALBUM
	@GetMapping("/add_album")
	public String addAlbum(Model model, Principal principal) {

		UserEntity entity = service.findUserByEmail(principal.getName());

		AddUserToAlbumRequestTwo request = UserMapper.entityToAddUserToAlbum(entity);
		model.addAttribute("albumModel", albumSer.showAlbums());
		model.addAttribute("addAlbum", request);

		return "user/addalbum";
	}

	@PostMapping("/add_album")
	public String saveAddedAlbum(@ModelAttribute("addAlbum") AddUserToAlbumRequestTwo request, Principal principal)
			throws IOException {
		UserEntity entity = service.findUserByEmail(principal.getName());
		// UserEntity entity = UserMapper.addRequestToEntityToAddAlbum(request);
		entity.setAlbums(request.getAlbums());
		service.editUser(entity);
		return "redirect:/user";
	}

	// ADD SONG
	@GetMapping("/add_song")
	public String addSong(Model model, Principal principal) {

		UserEntity entity = service.findUserByEmail(principal.getName());

		AddUserToSongRequest request = UserMapper.entityToAddSongToUser(entity);
		model.addAttribute("songModel", songService.showAllSongs());
		model.addAttribute("addSong", request);

		return "user/addsong";
	}

	@PostMapping("/add_song")
	public String saveAddedSong(@ModelAttribute("addSong") AddUserToSongRequest request, Principal principal)
			throws IOException {
		UserEntity entity = service.findUserByEmail(principal.getName());
		// UserEntity entity = UserMapper.addRequestToEntityToAddAlbum(request);
		entity.setSongs(request.getSongs());
		service.editUser(entity);
		return "redirect:/user/add_song";
	}

	// ADD ARTIST
	@GetMapping("/add_artist")
	public String addArtist(Model model, Principal principal) {

		UserEntity entity = service.findUserByEmail(principal.getName());

		AddUserToArtistRequest request = UserMapper.entityToAddUserToArtist(entity);
		model.addAttribute("artistModel", artistService.showAllArtists());
		model.addAttribute("addArtist", request);

		return "user/addartist";
	}

	@PostMapping("/add_artist")
	public String saveAddedArtist(@ModelAttribute("addArtist") AddUserToArtistRequest request, Principal principal)
			throws IOException {
		UserEntity entity = service.findUserByEmail(principal.getName());
		// UserEntity entity = UserMapper.addRequestToEntityToAddAlbum(request);
		entity.setArtists(request.getArtists());
		// entity.setId(request.getId());
		service.editUser(entity);
		return "redirect:/user/add_artist";
	}

	// ARTISTS LIBRARY
	@GetMapping("/artists_collection")
	public String showAddedArtists(Principal principal, Model model) {
		UserEntity entity = service.findUserByEmail(principal.getName());
		AddUserToArtistRequest request = UserMapper.entityToAddUserToArtist(entity);

		model.addAttribute("artistModel", request.getArtists());
		return "user/artistlist";
	}

	// ALBUMS LIBRARY
	@GetMapping("/albums_collection")
	public String showAddedAlbums(Principal principal, Model model) {
		UserEntity entity = service.findUserByEmail(principal.getName());
		AddUserToAlbumRequestTwo request = UserMapper.entityToAddUserToAlbum(entity);

		model.addAttribute("albumModel", request.getAlbums());
		return "user/albumslist";
	}

	// SONGSS LIBRARY
	@GetMapping("/songs_collection")
	public String showAddedSongs(Principal principal, Model model) {
		UserEntity entity = service.findUserByEmail(principal.getName());
		AddUserToSongRequest request = UserMapper.entityToAddSongToUser(entity);

		model.addAttribute("songModel", request.getSongs());
		return "user/songlist";
	}
}

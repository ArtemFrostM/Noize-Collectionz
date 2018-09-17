package com.noize.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noize.comparators.SongFollowersComparator;
import com.noize.domain.EditSongRequest;
import com.noize.entity.Album;
import com.noize.entity.Artist;
import com.noize.entity.Song;
import com.noize.entity.UserEntity;
import com.noize.mapper.SongMapper;
import com.noize.service.ArtistService;
import com.noize.service.SongService;
import com.noize.service.UserService;
import com.noize.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/song")
public class SongController {
	@Autowired
	private SongService service;
	@Autowired
	private UserService userService;
	@Autowired
	private ArtistService artistService;
	
	
	//SHOW SONG PROFILE
	@GetMapping("/{songId}")
	public String showSongProfile(Model model, @PathVariable("songId") int id) throws IOException {
		Song song = service.findSongById(id);
		song.increaseScore();
		
		model.addAttribute("ss", SongMapper.entityToSongProfile(song));
		model.addAttribute("imageSrc", CustomFileUtils.getImage("album_" + song.getAlbum().getId(), song.getAlbum().getAlbumImage()));

		return "song/profile";
	}
	
	//SHOW TOP SONGS
	@GetMapping("/top_list")
	public String showTopsongs(Model model) throws IOException {
		
		List<Song> songs = service.showAllSongs();
		
		Collections.sort(songs, new SongFollowersComparator());
		
		model.addAttribute("songModel", songs);

		return "song/songtoplist";
	}
	
	//SHOW TOP-30 SONGS
		@GetMapping("/top-30_list")
		public String showTop30songs(Model model) throws IOException {
			List<Song> songsTwo = new ArrayList<Song>();
			List<Song> songs = service.showAllSongs();
			
			Collections.sort(songs, new SongFollowersComparator());
			
			for(int i=0; i<30; i++) {
				songsTwo.add(songs.get(i));
			}
			
			model.addAttribute("songModel", songsTwo);

			return "song/songtop30list";
		}
	
	//EDIT SONG
	@GetMapping("/{songId}/edit")
	//@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	public String editSong(@PathVariable("songId") int id, Model model) {
		Song song = service.findSongById(id);
		
		EditSongRequest request = SongMapper.songToEditDomain(song);
		
		model.addAttribute("artistsModel", artistService.showAllArtists());
		model.addAttribute("songModel", request);
		
		return "song/edit";
	}
	
	@PostMapping("/{songId}/edit")
	public String saveSong(@PathVariable("songId") int id, @ModelAttribute EditSongRequest request) {
		Song song = service.findSongById(id);
		

		song.setArtists(request.getArtists());
		song.setName(request.getName());

		
		service.saveSong(song);
		return "redirect:/";
	}
	
	//DELETE SONG
	@GetMapping("/{songId}/delete_song")
	public String deleteSong(@PathVariable("songId") int id) {
		service.deleteSong(id);
		
		return "redirect:/";
	}
	
	
	//ADD FOLLOWER
	@GetMapping("/{songId}/add_follower")
	public String aadAlbumToFollow(@PathVariable("songId") int songId, Model model, Principal principal) {

		UserEntity entity = userService.findUserByEmail(principal.getName());

		List<Song> songs = entity.getSongs();
		
		boolean check = true;
		for(Song i: songs) {
			if(i.equals(service.findSongById(songId))) {
				check = false;
				break;
			}
		}
		if (check==true) {
			songs.add(service.findSongById(songId));
		}
		
		//songs.add(service.findSongById(songId));
		entity.setSongs(songs);
		userService.editUser(entity);

		model.addAttribute("songModel", service.findSongById(songId));
		model.addAttribute("addModel", entity);

		return "song/addfollower";
	}
	
	
}

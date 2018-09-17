package com.noize.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noize.domain.AlbumTitleFilter;
import com.noize.domain.ArtistNameFilter;
import com.noize.domain.CreateAlbumRequest;
import com.noize.domain.CreateAlbumRequestInArtist;
import com.noize.domain.EditArtistImageRequest;
import com.noize.domain.EditArtistRequest;
import com.noize.entity.Album;
import com.noize.entity.Artist;
import com.noize.entity.UserEntity;
import com.noize.entity.enumeration.AlbumType;
import com.noize.entity.enumeration.Genre;
import com.noize.mapper.AlbumMapper;
import com.noize.mapper.ArtistMapper;
import com.noize.mapper.UserMapper;
import com.noize.service.AlbumService;
import com.noize.service.ArtistService;
import com.noize.service.SongService;
import com.noize.service.UserService;
import com.noize.service.utils.CustomFileUtils;
import com.noize.sortlist.ArtistSorts;

@Controller
@RequestMapping("/artist")
public class ArtistController {
	@Autowired
	private ArtistService service;
	@Autowired
	private AlbumService alService;
	@Autowired
	private UserService userService;
	@Autowired
	private SongService songService;

	// SHOW ALL
	@GetMapping("/list")
	public String showArtists(Model model) throws IOException {
		List<Artist> artists = service.showAllArtists();
		for (int i = 0; i < artists.size(); i++) {
			String image = artists.get(i).getArtistImage();
			artists.get(i).setArtistImage(CustomFileUtils.getImage("artist_" + artists.get(i).getId(), image));
		}

		model.addAttribute("artistsModel", artists);
		return "artist/artistlist";
	}

	// SEARCH
	@GetMapping("/list/search")
	public String showArtistsByFilter(@PageableDefault Pageable pageable, Model model,
			@RequestParam("search") String search) {
		ArtistNameFilter filter = null;
		if (search != null) {
			filter = new ArtistNameFilter(search);
		}

		Page<Artist> page = service.findArtistsByName(pageable, filter);
		model.addAttribute("artistsModel", page.getContent());

		return "artist/artistloo";
	}
	
	// SHOW FILTERED ARTISTS
			@GetMapping("/filtered_list")
			public String showFilteredArtists(Model model) throws IOException {
				List<Artist> artists = service.showAllArtists();
				

				model.addAttribute("artistsModel", artists);
				return "artist/artistloo";
			}

	// SHOW ARTIST PROFILE
	@GetMapping("/{artistId}")
	public String showArtistProfile(@PathVariable("artistId") int id, Model model) throws IOException {
		Artist artist = service.findArtistById(id);
		artist.setScoreRating(artist.getScoreRating() + 1);
		;

		model.addAttribute("ss", ArtistMapper.entityToArtistProfile(artist));
		model.addAttribute("imageSrc", CustomFileUtils.getImage("artist_" + artist.getId(), artist.getArtistImage()));

		return "artist/profile";
	}

	// EDIT ARTIST
	@GetMapping("/{artistId}/edit")
	public String editArtist(@PathVariable("artistId") int id, Model model) {

		Artist artist = service.findArtistById(id);

		EditArtistRequest request = ArtistMapper.artistToEditDomain(artist);

		model.addAttribute("songsModel", songService.showAllSongs());
		model.addAttribute("albumsModel", alService.showAlbums());
		model.addAttribute("genreModel", Genre.values());
		model.addAttribute("artistModel", request);

		return "artist/edit";
	}

	@PostMapping("/{artistId}/edit")
	public String saveEditedArtist(@PathVariable("artistId") int id,
			@ModelAttribute("artistModel") EditArtistRequest request) {
		Artist artist = service.findArtistById(id);

		// artist = ArtistMapper.editRequestToArtist(request);
		// artist.setId(request.getId());
		artist.setAlbums(request.getAlbums());
		artist.setDescription(request.getDescription());
		artist.setName(request.getName());
		artist.setGenre(request.getGenre());
		artist.setSongs(request.getSongs());
		service.saveArtist(artist);

		return "redirect:/";
	}

	// EDIT ARTIST IMAGE
	@GetMapping("/{artistId}/edit_image")
	public String editArtistImage(@PathVariable("artistId") int id, Model model) throws IOException {

		Artist artist = service.findArtistById(id);

		EditArtistImageRequest request = ArtistMapper.artistToEditImageDomain(artist);

		model.addAttribute("artistModel", request);
		model.addAttribute("imageSrc", CustomFileUtils.getImage("artist_" + artist.getId(), artist.getArtistImage()));
		return "artist/editimage";
	}

	@PostMapping("/{artistId}/edit_image")
	public String saveEditedArtistImage(@PathVariable("artistId") int id,
			@ModelAttribute("artistModel") EditArtistImageRequest request) throws IOException {
		Artist artist = service.findArtistById(id);

		artist.setArtistImage(request.getFile().getOriginalFilename());
		service.saveArtist(artist);

		CustomFileUtils.createFolder("artist_" + artist.getId());
		CustomFileUtils.createImage("artist_" + artist.getId(), request.getFile());

		return "redirect:/";
	}

	// DELETE ARTIST
	@GetMapping("/{artistId}/delete_artist")
	public String deleteArtist(@PathVariable("artistId") int id) {
		service.deleteArtist(id);
		
		return "redirect:/artist/list";
	}
	
	
	// ADD ALBUM
	@GetMapping("/{artistId}/add_album")
	public String createAlbum(@PathVariable("artistId") int id, Model model) {
		Artist artist = service.findArtistById(id);
		CreateAlbumRequestInArtist request = new CreateAlbumRequestInArtist();
		request.setArtist(artist);
		
		List<Integer> years = new ArrayList<>();
		for(int i=1900; i<=2018; i++) {
			years.add(i);
		}
		
		model.addAttribute("yearsModel", years);
		model.addAttribute("title", "Create Album");
		model.addAttribute("albumModel", request);
		model.addAttribute("genresA", Genre.values());
		model.addAttribute("alType", AlbumType.values());

		return "artist/createalbum";
	}

	@PostMapping("/{artistId}/add_album")
	public String createALbumInArtist(@ModelAttribute("albumModel") CreateAlbumRequestInArtist request,
			@PathVariable("artistId") int id) throws IOException {
		Artist artist = service.findArtistById(id);
		Album album = AlbumMapper.createRequestToAlbumInArtist(request);

		album.setArtist(artist);
		alService.saveAlbum(album);

		CustomFileUtils.createFolder("album_" + album.getId());
		CustomFileUtils.createImage("album_" + album.getId(), request.getFile());
		return "redirect:/";
	}

	// ADD FOLLOWER

	@GetMapping("/{artistId}/add_follower")
	public String aadAlbumToFollow(@PathVariable("artistId") int arId, Model model, Principal principal) {

		UserEntity entity = userService.findUserByEmail(principal.getName());

		List<Artist> artists = entity.getArtists();
		boolean check = true;
		for(Artist i: artists) {
			if(i.equals(service.findArtistById(arId))) {
				check = false;
				break;
			}
		}
		if (check==true) {
			artists.add(service.findArtistById(arId));
		}
		
		//artists.add(service.findArtistById(arId));
		entity.setArtists(artists);
		userService.editUser(entity);

		model.addAttribute("artistModel", service.findArtistById(arId));
		model.addAttribute("addModel", entity);

		return "artist/addfollower";
	}

	// SHOW TOP ARTISTS
	@GetMapping("/top_list")
	public String showTopArtists(Model model) throws IOException {
		model.addAttribute("artistsModel", ArtistSorts.showTopArtists(service));

		return "artist/artisttoplist";
	}

	// SHOW ONLY ALTERNATIVE ARTISTS
	@GetMapping("/alternative_list")
	public String showAlternativeArtists(Model model) throws IOException {
		model.addAttribute("artistsModel", ArtistSorts.showAlternativeArtists(service));

		return "artist/artistalternativelist";
	}

	// SHOW ONLY ROCK ARTISTS
	@GetMapping("/rock_list")
	public String showRockArtists(Model model) throws IOException {
		model.addAttribute("artistsModel", ArtistSorts.showRockArtists(service));

		return "artist/artistrocklist";
	}

	// SHOW ONLY RAP ARTISTS
	@GetMapping("/rap_list")
	public String showRapArtists(Model model) throws IOException {
		model.addAttribute("artistsRapModel", ArtistSorts.showRapArtists(service));

		return "artist/artistraplist";
	}

	// SHOW ONLY DISCO ARTISTS
	@GetMapping("/disco_list")
	public String showDiscoArtists(Model model) throws IOException {
		model.addAttribute("artistsRapModel", ArtistSorts.showDiscoArtists(service));

		return "artist/artistdiscolist";
	}

	// SHOW ONLY HOUSE ARTISTS
	@GetMapping("/house_list")
	public String showHouseArtists(Model model) throws IOException {
		model.addAttribute("artistsRapModel", ArtistSorts.showHouseArtists(service));

		return "artist/artisthouselist";
	}

	// SHOW ONLY TRAP ARTISTS
	@GetMapping("/trap_list")
	public String showTrapArtists(Model model) throws IOException {
		model.addAttribute("artistsRapModel", ArtistSorts.showTrapArtists(service));

		return "artist/artisttraplist";
	}

	// SHOW ONLY POP ARTISTS
	@GetMapping("/pop_list")
	public String showPopArtists(Model model) throws IOException {
		model.addAttribute("artistsRapModel", ArtistSorts.showPopArtists(service));

		return "artist/artistpoplist";
	}
}

// @GetMapping("/list")
// public String showArtists (Model model) {
// List<Artist> artists = service.showAllArtists();
// model.addAttribute("artistsModel", artists);
// //model.addAttribute("imageSrc", CustomFileUtils.getImage("user_" +
// artists.getId(), entity.getImagePath()));
//
// return "artist/artistlist";
// }

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
import com.noize.domain.CreateSongRequest;
import com.noize.domain.EditAlbumImage;
import com.noize.domain.EditAlbumRequest;
import com.noize.entity.Album;
import com.noize.entity.Song;
import com.noize.entity.UserEntity;
import com.noize.entity.enumeration.AlbumType;
import com.noize.entity.enumeration.Genre;
import com.noize.mapper.AlbumMapper;
import com.noize.mapper.SongMapper;
import com.noize.service.AlbumService;
import com.noize.service.ArtistService;
import com.noize.service.SongService;
import com.noize.service.UserService;
import com.noize.service.utils.CustomFileUtils;
import com.noize.sortlist.AlbumsSorts;

@Controller
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService service;
	@Autowired
	private SongService songService;
	@Autowired
	private ArtistService artistService;
	@Autowired
	private UserService userService;;

	// SHOW ALL ALBUMS
	@GetMapping("/list")
	public String showAlbums(Model model) throws IOException {
		List<Album> albums = service.showAlbums();
		for (int i = 0; i < albums.size(); i++) {
			String image = albums.get(i).getAlbumImage();
			albums.get(i).setAlbumImage(CustomFileUtils.getImage("album_" + albums.get(i).getId(), image));
		}

		model.addAttribute("albumsModel", albums);
		return "album/albums";
	}

	// SEARCH
	@GetMapping("/list/search")
	public String showAlbumsByFilter(@PageableDefault Pageable pageable, Model model,
			@RequestParam("search") String search) {
		AlbumTitleFilter filter = null;
		if (search != null) {
			filter = new AlbumTitleFilter(search);
		}

		Page<Album> page = service.findAllAlbumsByTitle(pageable, filter);
		model.addAttribute("albumsModel", page.getContent());

		return "album/albumsloo";
	}
	
	// SHOW FILTERED ALBUMS
		@GetMapping("/filtered_list")
		public String showFilteredAlbums(Model model) throws IOException {
			List<Album> albums = service.showAlbums();
			

			model.addAttribute("albumsModel", albums);
			return "album/albumsloo";
		}

	// ALBUM PROFILE
	@GetMapping("/{albumId}")
	public String showAlbumProfile(@PathVariable("albumId") int id, Model model, Principal principal)
			throws IOException {
		Album album = service.findAlbumById(id);
		album.setScoreRating(album.getScoreRating() + 1);

		model.addAttribute("ss", AlbumMapper.entityToArtistProfile(album));
		model.addAttribute("imageSrc", CustomFileUtils.getImage("album_" + album.getId(), album.getAlbumImage()));

		return "album/profile";
	}

	// EDIT ALBUM
	@GetMapping("/{albumId}/edit")
	public String editAlbum(@PathVariable("albumId") int id, Model model) throws IOException {
		Album album = service.findAlbumById(id);

		EditAlbumRequest request = AlbumMapper.albumToEditDomain(album);
		
		List<Integer> years = new ArrayList<>();
		for(int i=1900; i<=2018; i++) {
			years.add(i);
		}
		
		model.addAttribute("yearsModel", years);
		model.addAttribute("genreModel", Genre.values());
		model.addAttribute("alType", AlbumType.values());
		model.addAttribute("albumModel", request);
		// model.addAttribute ("imageSrc", CustomFileUtils.getImage("album_" +
		// album.getId(), album.getAlbumImage()));

		return "album/edit";
	}

	@PostMapping("/{albumId}/edit")
	public String saveEditedAlbum(@PathVariable("albumId") int id, @ModelAttribute EditAlbumRequest request)
			throws IOException {
		Album album = service.findAlbumById(id);

		album.setAlbumType(request.getAlbumType());
		album.setGenre(request.getGenre());
		album.setTitle(request.getTitle());
		album.setYear(request.getYear());
		service.saveAlbum(album);
		// CustomFileUtils.createFolder("album_" + album.getId());
		// CustomFileUtils.createImage("album_" + album.getId(), request.getFile());

		return "redirect:/";
	}

	// EDIT ALBUM IMAGE
	@GetMapping("/{albumId}/edit_image")
	public String editAlbumImage(@PathVariable("albumId") int id, Model model) throws IOException {
		Album album = service.findAlbumById(id);

		EditAlbumImage request = AlbumMapper.albumToEditImageDomain(album);
		model.addAttribute("albumModel", request);
		model.addAttribute("imageSrc", CustomFileUtils.getImage("album_" + album.getId(), album.getAlbumImage()));

		return "album/editimage";
	}

	@PostMapping("/{albumId}/edit_image")
	public String saveEditedAlbumImage(@PathVariable("albumId") int id, @ModelAttribute EditAlbumImage request)
			throws IOException {
		Album album = service.findAlbumById(id);
		album.setAlbumImage(request.getFile().getOriginalFilename());
		service.saveAlbum(album);
		CustomFileUtils.createFolder("album_" + album.getId());
		CustomFileUtils.createImage("album_" + album.getId(), request.getFile());

		return "redirect:/";
	}

	//DELETE ALBUM
	@GetMapping("/{albumId}/delete_album")
	public String deleteAlbum(@PathVariable("albumId") int id) {
		service.deleteAlbum(id);
		
		return "redirect:/album/list";
	}
	
	
	@GetMapping("/{albumId}/add_song")
	public String createAlbum(@PathVariable("albumId") int id, Model model) {

		Album album = service.findAlbumById(id);
		CreateSongRequest request = new CreateSongRequest();
		request.setAlbum(album);

		model.addAttribute("artistModel", artistService.showAllArtists());
		model.addAttribute("title", "Create Song");
		model.addAttribute("songModel", request);

		return "album/createsong";
	}

	@PostMapping("/{albumId}/add_song")
	public String createSong(@ModelAttribute("songModel") CreateSongRequest request, @PathVariable("albumId") int id)
			throws IOException {
		Album album = service.findAlbumById(id);
		Song song = SongMapper.createRequestToSong(request);

		song.setAlbum(album);
		songService.saveSong(song);

		CustomFileUtils.createFolder("song_" + song.getId());
		return "redirect:/";
	}

	// ADD Follower

	@GetMapping("/{albumId}/add_follower")
	public String aadAlbumToFollow(@PathVariable("albumId") int alId, Model model, Principal principal) {

		UserEntity entity = userService.findUserByEmail(principal.getName());

		List<Album> albums = entity.getAlbums();
		boolean check = true;
		for(Album i: albums) {
			if(i.equals(service.findAlbumById(alId))) {
				check = false;
				break;
			}
		}
		if (check==true) {
			albums.add(service.findAlbumById(alId));
		}
		entity.setAlbums(albums);
		userService.editUser(entity);

		model.addAttribute("albumModel", service.findAlbumById(alId));
		model.addAttribute("addModel", entity);

		return "album/addfollower";
	}

	// SHOW TOP
	@GetMapping("/top_list")
	public String showTopAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showTop(service));

		return "album/albumaltoplist";
	}

	// SHOW ONLY ALTERNATIVE ALBUMS
	@GetMapping("/alternative_list")
	public String showAlternativeAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showAlternativeAlbums(service));

		return "album/albumalternativelist";
	}

	// SHOW ONLY ROCK ALBUMS
	@GetMapping("/rock_list")
	public String showRockAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showRockAlbums(service));

		return "album/albumrocklist";
	}

	// SHOW ONLY RAP ALBUMS
	@GetMapping("/rap_list")
	public String showRapAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showRapAlbums(service));

		return "album/albumraplist";
	}

	// SHOW ONLY TRAP ALBUMS
	@GetMapping("/trap_list")
	public String showTrapAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showTrapAlbums(service));

		return "album/albumtraplist";
	}

	// SHOW ONLY DISCO ALBUMS
	@GetMapping("/disco_list")
	public String showDiscoAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showDiscoAlbums(service));

		return "album/albumdiscolilst";
	}

	// SHOW ONLY POP ALBUMS
	@GetMapping("/pop_list")
	public String showPopAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showPopAlbums(service));

		return "album/albumpoplist";
	}

	// SHOW ONLY HOUSE ALBUMS
	@GetMapping("/house_list")
	public String showHouseAlbums(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showHouseAlbums(service));

		return "album/albumhouselist";
	}

	// ALBUM TYPES

	// SHOW ONLY LP's
	@GetMapping("/lp_list")
	public String showLp(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showLp(service));

		return "album/albumlplist";
	}

	// SHOW ONLY EP's
	@GetMapping("/ep_list")
	public String showEp(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showEp(service));

		return "album/albumeplist";
	}

	// SHOW ONLY REMIXES
	@GetMapping("/remix_list")
	public String showRemix(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showRemixes(service));

		return "album/albumremixlist";
	}

	// SHOW ONLY SINGLES
	@GetMapping("/single_list")
	public String showSingles(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showSingles(service));

		return "album/albumsinglelist";
	}

	// SHOW ONLY MIXTYPES
	@GetMapping("/mixtype_list")
	public String showMixtype(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.showMixtype(service));

		return "album/albummixtypelist";
	}

	// SHOW 1995
	@GetMapping("/1995_list")
	public String show1995(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show1995(service));

		return "album/album1995list";
	}

	// SHOW 1996
	@GetMapping("/1996_list")
	public String show1996(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show1996(service));

		return "album/album1996list";
	}

	// SHOW 1997
	@GetMapping("/1997_list")
	public String show1997(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show1997(service));

		return "album/album1997list";
	}

	// SHOW 1998
	@GetMapping("/1998_list")
	public String show1998(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show1998(service));

		return "album/album1998list";
	}

	// SHOW 1999
	@GetMapping("/1999_list")
	public String show1999(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show1999(service));

		return "album/album1999list";
	}

	// SHOW 2000
	@GetMapping("/2000_list")
	public String show2000(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2000(service));

		return "album/album2000list";
	}

	// SHOW 2001
	@GetMapping("/2001_list")
	public String show2001(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2001(service));

		return "album/album2001list";
	}

	// SHOW 2002
	@GetMapping("/2002_list")
	public String show2002(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2002(service));

		return "album/album2002list";
	}

	// SHOW 2003
	@GetMapping("/2003_list")
	public String show2003(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2003(service));

		return "album/album2003list";
	}

	// SHOW 2004
	@GetMapping("/2004_list")
	public String show2004(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2004(service));

		return "album/album2004list";
	}

	// SHOW 2005
	@GetMapping("/2005_list")
	public String show2005(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2005(service));

		return "album/album2005list";
	}

	// SHOW 2006
	@GetMapping("/2006_list")
	public String show2006(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2006(service));

		return "album/album2006list";
	}

	// SHOW 2007
	@GetMapping("/2007_list")
	public String show2007(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2207(service));

		return "album/album2007list";
	}

	// SHOW 2008
	@GetMapping("/2008_list")
	public String show2008(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2008(service));

		return "album/album2008list";
	}

	// SHOW 2009
	@GetMapping("/2009_list")
	public String show2009(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2009(service));

		return "album/album2009list";
	}

	// SHOW 2010
	@GetMapping("/2010_list")
	public String show2010(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2010(service));

		return "album/album2010list";
	}

	// SHOW 2011
	@GetMapping("/2011_list")
	public String show2011(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2011(service));

		return "album/album2011list";
	}

	// SHOW 2012
	@GetMapping("/2012_list")
	public String show2012(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2012(service));

		return "album/album2012list";
	}

	// SHOW 2013
	@GetMapping("/2013_list")
	public String show2013(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2013(service));

		return "album/album2013list";
	}

	// SHOW 2014
	@GetMapping("/2014_list")
	public String show2014(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2014(service));

		return "album/album2014list";
	}

	// SHOW 2015
	@GetMapping("/2015_list")
	public String show2015(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2015(service));

		return "album/album2015list";
	}

	// SHOW 2016
	@GetMapping("/2016_list")
	public String show2016(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2016(service));

		return "album/album2016list";
	}

	// SHOW 2017
	@GetMapping("/2017_list")
	public String show2017(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2017(service));

		return "album/album2017list";
	}

	// SHOW 2018
	@GetMapping("/2018_list")
	public String show2018(Model model) throws IOException {
		model.addAttribute("albumsModel", AlbumsSorts.show2018(service));

		return "album/album2018list";
	}

}

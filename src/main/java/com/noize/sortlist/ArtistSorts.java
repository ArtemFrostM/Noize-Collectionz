package com.noize.sortlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.noize.comparators.ArtistFollowersComparator;
import com.noize.entity.Artist;
import com.noize.entity.enumeration.Genre;
import com.noize.service.ArtistService;
import com.noize.service.utils.CustomFileUtils;

public class ArtistSorts {
	// @Autowired
	// private ArtistService service;
	
	
	//SHOW TOP ARTISTS
	public static List<Artist> showTopArtists(ArtistService service) throws IOException {
		List<Artist> artistsTwo = new ArrayList<>();
		List<Artist> artists = service.showAllArtists();
		Collections.sort(artists, new ArtistFollowersComparator());

		for (int i = 0; i < artists.size(); i++) {
			String image = artists.get(i).getArtistImage();
			String base64 = CustomFileUtils.getImage("artist_" + artists.get(i).getId(), image);
			artists.get(i).setArtistImage(base64);
		}
		
		for(int i=0; i<30; i++) {
			artistsTwo.add(artists.get(i));
		}
		return artistsTwo;
	}
	
	
	// SHOW ONLY RAP ARTISTS
	public static List<Artist> showRapArtists(ArtistService service) throws IOException {
		List<Artist> artistsTwo = new ArrayList<>();
		List<Artist> artists = service.showAllArtists();

		for (int i = 0; i < artists.size(); i++) {
			System.out.println(artists.get(i).getGenre().getId() == (Genre.RAP.getId()));
			if ((artists.get(i).getGenre().getId() == (Genre.RAP.getId()))) {
				artistsTwo.add(artists.get(i));
			}
		}
		for (int i = 0; i < artistsTwo.size(); i++) {
			String image = artistsTwo.get(i).getArtistImage();
			String base64 = CustomFileUtils.getImage("artist_" + artistsTwo.get(i).getId(), image);
			artistsTwo.get(i).setArtistImage(base64);
		}
		for (Artist i : artistsTwo) {
			System.out.println(i.getName() + "\n");
		}
		for (Artist i : artists) {
			System.out.println(i.getName());
		}
		return artistsTwo;
	}

	// SHOW ONLY Alternative ARTISTS
	public static List<Artist> showAlternativeArtists(ArtistService service) throws IOException {
		List<Artist> artistsTwo = new ArrayList<>();
		List<Artist> artists = service.showAllArtists();

		for (int i = 0; i < artists.size(); i++) {
			if ((artists.get(i).getGenre().getId() == (Genre.ALTERNATIVE.getId()))) {
				artistsTwo.add(artists.get(i));
			}
		}
		for (int i = 0; i < artistsTwo.size(); i++) {
			String image = artistsTwo.get(i).getArtistImage();
			String base64 = CustomFileUtils.getImage("artist_" + artistsTwo.get(i).getId(), image);
			artistsTwo.get(i).setArtistImage(base64);
		}
		return artistsTwo;
	}

	// SHOW ONLY DISCO ARTISTS
	public static List<Artist> showDiscoArtists(ArtistService service) throws IOException {
		List<Artist> artistsTwo = new ArrayList<>();
		List<Artist> artists = service.showAllArtists();

		for (int i = 0; i < artists.size(); i++) {
			if ((artists.get(i).getGenre().getId() == (Genre.DISCO.getId()))) {
				artistsTwo.add(artists.get(i));
			}
		}
		for (int i = 0; i < artistsTwo.size(); i++) {
			String image = artistsTwo.get(i).getArtistImage();
			String base64 = CustomFileUtils.getImage("artist_" + artistsTwo.get(i).getId(), image);
			artistsTwo.get(i).setArtistImage(base64);
		}
		return artistsTwo;
	}

	// SHOW ONLY HOUSE ARTISTS
	public static List<Artist> showHouseArtists(ArtistService service) throws IOException {
		List<Artist> artistsTwo = new ArrayList<>();
		List<Artist> artists = service.showAllArtists();

		for (int i = 0; i < artists.size(); i++) {
			if ((artists.get(i).getGenre().getId() == (Genre.HOUSE.getId()))) {
				artistsTwo.add(artists.get(i));
			}
		}
		for (int i = 0; i < artistsTwo.size(); i++) {
			String image = artistsTwo.get(i).getArtistImage();
			String base64 = CustomFileUtils.getImage("artist_" + artistsTwo.get(i).getId(), image);
			artistsTwo.get(i).setArtistImage(base64);
		}
		return artistsTwo;
	}

	// SHOW ONLY TRAP ARTISTS
	public static List<Artist> showTrapArtists(ArtistService service) throws IOException {
		List<Artist> artistsTwo = new ArrayList<>();
		List<Artist> artists = service.showAllArtists();

		for (int i = 0; i < artists.size(); i++) {
			if ((artists.get(i).getGenre().getId() == (Genre.TRAP.getId()))) {
				artistsTwo.add(artists.get(i));
			}
		}
		for (int i = 0; i < artistsTwo.size(); i++) {
			String image = artistsTwo.get(i).getArtistImage();
			String base64 = CustomFileUtils.getImage("artist_" + artistsTwo.get(i).getId(), image);
			artistsTwo.get(i).setArtistImage(base64);
		}
		return artistsTwo;
	}

	// SHOW ONLY POP ARTISTS
	public static List<Artist> showPopArtists(ArtistService service) throws IOException {
		List<Artist> artistsTwo = new ArrayList<>();
		List<Artist> artists = service.showAllArtists();

		for (int i = 0; i < artists.size(); i++) {
			if ((artists.get(i).getGenre().getId() == (Genre.POP.getId()))) {
				artistsTwo.add(artists.get(i));
			}
		}
		for (int i = 0; i < artistsTwo.size(); i++) {
			String image = artistsTwo.get(i).getArtistImage();
			String base64 = CustomFileUtils.getImage("artist_" + artistsTwo.get(i).getId(), image);
			artistsTwo.get(i).setArtistImage(base64);
		}
		return artistsTwo;
	}
	
	// SHOW ONLY ROCK ARTISTS
		public static List<Artist> showRockArtists(ArtistService service) throws IOException {
			List<Artist> artistsTwo = new ArrayList<>();
			List<Artist> artists = service.showAllArtists();

			for (int i = 0; i < artists.size(); i++) {
				if ((artists.get(i).getGenre().getId() == (Genre.ROCK.getId()))) {
					artistsTwo.add(artists.get(i));
				}
			}
			for (int i = 0; i < artistsTwo.size(); i++) {
				String image = artistsTwo.get(i).getArtistImage();
				String base64 = CustomFileUtils.getImage("artist_" + artistsTwo.get(i).getId(), image);
				artistsTwo.get(i).setArtistImage(base64);
			}
			return artistsTwo;
		}
}

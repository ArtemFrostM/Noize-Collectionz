package com.noize.sortlist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.noize.comparators.AlbumFollowersComparator;
import com.noize.entity.Album;
import com.noize.entity.enumeration.AlbumType;
import com.noize.entity.enumeration.Genre;
import com.noize.service.AlbumService;
import com.noize.service.utils.CustomFileUtils;


public class AlbumsSorts {

	// SHOW ONLY Alternative ALBUMS
	public static List<Album> showAlternativeAlbums(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getGenre().getId() == (Genre.ALTERNATIVE.getId()))) {
				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY ROCK ALBUMS
	public static List<Album> showRockAlbums(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getGenre().getId() == (Genre.ROCK.getId()))) {
				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY RAP ALBUMS
	public static List<Album> showRapAlbums(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getGenre().getId() == (Genre.RAP.getId()))) {
				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY DISCO ALBUMS
	public static List<Album> showDiscoAlbums(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getGenre().getId() == (Genre.DISCO.getId()))) {
				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY TRAP ALBUMS
	public static List<Album> showTrapAlbums(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getGenre().getId() == (Genre.TRAP.getId()))) {
				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY HOUSE ALBUMS
	public static List<Album> showHouseAlbums(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getGenre().getId() == (Genre.HOUSE.getId()))) {
				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY POP ALBUMS
	public static List<Album> showPopAlbums(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getGenre().getId() == (Genre.POP.getId()))) {
				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// ALBUM TYPES
	// if ((albums.get(i).getYear() == 1995)) {
	// SHOW ONLY LP's
	public static List<Album> showLp(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getAlbumType().getId() == (AlbumType.LP.getId()))) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY EP's
	public static List<Album> showEp(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getAlbumType().getId() == (AlbumType.EP.getId()))) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY REMIXES
	public static List<Album> showRemixes(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getAlbumType().getId() == (AlbumType.REMIX.getId()))) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY MIXTYPE
	public static List<Album> showMixtype(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getAlbumType().getId() == (AlbumType.MIXTYPE.getId()))) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY SINGLES
	public static List<Album> showSingles(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getAlbumType().getId() == (AlbumType.SINGLE.getId()))) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// YEARS

	// SHOW ONLY 1995
	public static List<Album> show1995(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 1995)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 1996
	public static List<Album> show1996(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 1996)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 1997
	public static List<Album> show1997(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 1997)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 1998
	public static List<Album> show1998(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 1998)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 1999
	public static List<Album> show1999(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 1999)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2000
	public static List<Album> show2000(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2000)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2001
	public static List<Album> show2001(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2001)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2002
	public static List<Album> show2002(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2002)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2003
	public static List<Album> show2003(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2003)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2004
	public static List<Album> show2004(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2004)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2005
	public static List<Album> show2005(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2005)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2006
	public static List<Album> show2006(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2006)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2007
	public static List<Album> show2207(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2007)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2008
	public static List<Album> show2008(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2008)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2009
	public static List<Album> show2009(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2009)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2010
	public static List<Album> show2010(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2010)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2011
	public static List<Album> show2011(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2011)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2012
	public static List<Album> show2012(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2012)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2013
	public static List<Album> show2013(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2013)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2014
	public static List<Album> show2014(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2014)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2015
	public static List<Album> show2015(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2015)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2016
	public static List<Album> show2016(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2016)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2017
	public static List<Album> show2017(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2017)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}

	// SHOW ONLY 2018
	public static List<Album> show2018(AlbumService service) throws IOException {
		List<Album> albumsTwo = new ArrayList<>();
		List<Album> albums = service.showAlbums();

		for (int i = 0; i < albums.size(); i++) {
			if ((albums.get(i).getYear() == 2018)) {

				albumsTwo.add(albums.get(i));
			}
		}
		for (int i = 0; i < albumsTwo.size(); i++) {
			String image = albumsTwo.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albumsTwo.get(i).getId(), image);
			albumsTwo.get(i).setAlbumImage(base64);
		}
		return albumsTwo;
	}
	
	//SHOW TOP 
	public static List<Album> showTop(AlbumService service) throws IOException {
		//List<Album> albumsTwo = new ArrayList<>();
		
		
		List<Album> albums = service.showAlbums();
		
		Collections.sort(albums, new AlbumFollowersComparator());

		
		for (int i = 0; i < albums.size(); i++) {
			String image = albums.get(i).getAlbumImage();
			String base64 = CustomFileUtils.getImage("album_" + albums.get(i).getId(), image);
			albums.get(i).setAlbumImage(base64);
		}
		List<Album> albumsTwo = new ArrayList<>();
		
		for(int i=0; i<30; i++) {
			albumsTwo.add(albums.get(i));
		}
		
		return albumsTwo;
	}

}

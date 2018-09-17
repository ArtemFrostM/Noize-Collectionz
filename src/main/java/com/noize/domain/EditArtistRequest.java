package com.noize.domain;

import java.util.List;


import com.noize.entity.Album;
import com.noize.entity.Song;
import com.noize.entity.UserEntity;
import com.noize.entity.enumeration.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EditArtistRequest {
	private int id;
	private String name;
	private String description;
	private Genre genre;
	private String artistImage;
	List<Album> albums;
	List<Song> songs;
	List<UserEntity> users;
}

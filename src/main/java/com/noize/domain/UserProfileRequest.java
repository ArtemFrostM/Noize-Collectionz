package com.noize.domain;

import java.util.List;

import com.noize.entity.Album;
import com.noize.entity.Artist;
import com.noize.entity.Song;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserProfileRequest {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String nickname;
	private int age;
	private List<Album> albums;
	private List<Artist> artist;
	private List<Song> songs;
	
}

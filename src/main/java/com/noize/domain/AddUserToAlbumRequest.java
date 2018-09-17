package com.noize.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.noize.entity.Artist;
import com.noize.entity.Song;
import com.noize.entity.UserEntity;
import com.noize.entity.enumeration.AlbumType;
import com.noize.entity.enumeration.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter @Setter
public class AddUserToAlbumRequest {
	private String title;
	private int year;
	private MultipartFile file;
	private Genre genre;
	private AlbumType albumType;
	private Artist artist;
	List<UserEntity> users;
	List<Song> songs;
	private int id;
}

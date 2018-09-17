package com.noize.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class EditAlbumRequest {
	
	private int id;
	private String title;
	private int year;
	private Genre genre;
	private AlbumType albumType;
	private Artist artist;
	List<UserEntity> users;
	List<Song> songs;
	private MultipartFile file;
}

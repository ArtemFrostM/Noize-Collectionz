package com.noize.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.noize.entity.Artist;
import com.noize.entity.Song;
import com.noize.entity.enumeration.AlbumType;
import com.noize.entity.enumeration.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter @Setter
public class AlbumProfileRequest {
		private int id;
		private String title;
		private int year;
		private Genre genre;
		private MultipartFile file;
		private Artist artist;
		private AlbumType albumType;
		private List<Song> songs;
}

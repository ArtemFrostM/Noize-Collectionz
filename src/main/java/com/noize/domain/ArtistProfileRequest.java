package com.noize.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.noize.entity.Album;
import com.noize.entity.enumeration.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ArtistProfileRequest {
		private int id;
		private String name;
		private String description;
		private String imagePath;
		private Genre genre;
		//private
		private MultipartFile file;
		private List<Album> albums;
		
	
}

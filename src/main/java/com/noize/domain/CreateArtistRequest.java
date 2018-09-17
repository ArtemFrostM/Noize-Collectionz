package com.noize.domain;


import org.springframework.web.multipart.MultipartFile;

import com.noize.entity.enumeration.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CreateArtistRequest {
	private int id;
	private String name;
	private String description;
	private String imagePath;
	private Genre genre;
	private MultipartFile file;

}

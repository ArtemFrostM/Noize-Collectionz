package com.noize.domain;

import org.springframework.web.multipart.MultipartFile;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EditAlbumImage {
	private int id;
	private MultipartFile file;
}

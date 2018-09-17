package com.noize.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.noize.entity.Album;
import com.noize.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter @Setter
public class AddUserToAlbumRequestTwo {
	
		private int id;
		private String email;
		private String password;
		private String firstName;
		private String lastName;
		private int age;
		private MultipartFile file;
		private Role role;
		private String nickname;
		private List<Album> albums;
}

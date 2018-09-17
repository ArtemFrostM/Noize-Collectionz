package com.noize.mapper;

import static org.mockito.Matchers.endsWith;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.noize.domain.AddUserToAlbumRequest;
import com.noize.domain.AddUserToAlbumRequestTwo;
import com.noize.domain.AddUserToArtistRequest;
import com.noize.domain.AddUserToSongRequest;
import com.noize.domain.EditImage;
import com.noize.domain.EditUserRequest;
import com.noize.domain.RegisterRequest;
import com.noize.domain.UserProfileRequest;
import com.noize.entity.UserEntity;
import com.noize.entity.enumeration.Role;

public interface UserMapper {

	public static User toSecurityUser(UserEntity entity) {
		return new User(entity.getEmail(), entity.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(entity.getRole())));
	}
	
	public static UserEntity registerToUser(RegisterRequest request) {
		UserEntity entity = new UserEntity();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setRole(Role.ROLE_USER);
		return entity;
	}
	
	public static UserProfileRequest entityToUserProfile(UserEntity entity) {
		UserProfileRequest request = new UserProfileRequest();
		request.setId(entity.getId());
		request.setFirstName(entity.getFirstName());
		request.setLastName(entity.getLastName());
		request.setAge(entity.getAge());
		request.setEmail(entity.getEmail());
		request.setNickname(entity.getNickname());
		request.setAlbums(entity.getAlbums());
		request.setArtist(entity.getArtists());
		request.setSongs(entity.getSongs());
		
		return request;
	}
	
	//EDIT USER
	public static EditUserRequest entityToEditUser(UserEntity entity) {
		EditUserRequest request = new EditUserRequest();
		
		request.setId(entity.getId());
		request.setEmail(entity.getEmail());
		request.setFirstName(entity.getFirstName());
		request.setLastName(request.getLastName());
		request.setAge(entity.getAge());
		request.setNickname(entity.getNickname());
		request.setPassword(entity.getPassword());
		
		return request;
	}
	
	public static UserEntity editRequestToEntity(EditUserRequest request) {
		UserEntity entity = new UserEntity();
		entity.setId(request.getId());
		entity.setEmail(request.getEmail());
		entity.setFirstName(request.getFirstName());
		entity.setLastName(request.getLastName());
		entity.setAge(request.getAge());
		entity.setNickname(request.getNickname());
		entity.setPassword(request.getPassword());
		//entity.setImagePath(request.getFile().getOriginalFilename());
		entity.setRole(Role.ROLE_USER);
		
		return entity;
	}
	
	//ADD USER TO ALBUM
		public static AddUserToAlbumRequestTwo entityToAddUserToAlbum(UserEntity entity) {
			AddUserToAlbumRequestTwo request = new AddUserToAlbumRequestTwo();
			
			request.setId(entity.getId());
			request.setEmail(entity.getEmail());
			request.setFirstName(entity.getFirstName());
			request.setLastName(request.getLastName());
			request.setAge(entity.getAge());
			request.setNickname(entity.getNickname());
//			request.setPassword(entity.getPassword());
			request.setAlbums(entity.getAlbums());
			
			return request;
		}
		
		public static UserEntity addRequestToEntityToAddAlbum(AddUserToAlbumRequestTwo request) {
			UserEntity entity = new UserEntity();
			entity.setId(request.getId());
//			entity.setEmail(request.getEmail());
//			entity.setFirstName(request.getFirstName());
//			entity.setLastName(request.getLastName());
//			entity.setAge(request.getAge());
//			entity.setNickname(request.getNickname());
//			entity.setPassword(request.getPassword());
//			//entity.setImagePath(request.getFile().getOriginalFilename());
//			entity.setRole(Role.ROLE_USER);
			entity.setAlbums(request.getAlbums());
			
			return entity;
		}
		
		//ADD USER TO Song
				public static AddUserToSongRequest entityToAddSongToUser(UserEntity entity) {
					AddUserToSongRequest request = new AddUserToSongRequest();
					
					request.setId(entity.getId());
//					request.setEmail(entity.getEmail());
//					request.setFirstName(entity.getFirstName());
//					request.setLastName(request.getLastName());
//					request.setAge(entity.getAge());
//					request.setNickname(entity.getNickname());
//					request.setPassword(entity.getPassword());
					request.setSongs(entity.getSongs());
					
					return request;
				}
				
				//ADD USER TO ARTIST
				public static AddUserToArtistRequest entityToAddUserToArtist(UserEntity entity) {
					AddUserToArtistRequest request = new AddUserToArtistRequest();
					
					request.setId(entity.getId());
//					request.setEmail(entity.getEmail());
//					request.setFirstName(entity.getFirstName());
//					request.setLastName(request.getLastName());
//					request.setAge(entity.getAge());
//					request.setNickname(entity.getNickname());
//					request.setPassword(entity.getPassword());
					request.setArtists(entity.getArtists());
					
					return request;
				}
	
	//EDIT IMAGE
	public static EditImage entityToEditImage(UserEntity entity) {
		EditImage request = new EditImage();
		request.setId(entity.getId());
		request.setId(entity.getId());
		request.setEmail(entity.getEmail());
		request.setFirstName(entity.getFirstName());
		request.setLastName(request.getLastName());
		request.setAge(entity.getAge());
		request.setNickname(entity.getNickname());
		request.setPassword(entity.getPassword());
		
		return request;
	}
	
	public static UserEntity editImageRequestToEntity (EditImage request) {
		UserEntity entity = new UserEntity();
		//entity.setId(request.getId());
		entity.setImagePath(request.getFile().getOriginalFilename());
		
		return entity;
	}
	
}

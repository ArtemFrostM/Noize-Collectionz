package com.noize.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.noize.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "user", indexes = @Index(columnList = "email"))
public class UserEntity extends BaseEntity {
	
	private String email;
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	private int age;
	
	@Column(name = "image_path")
	private String imagePath;
	private Role role;
	@Column(name = "nickname")
	private String nickname;
	
	@ManyToMany (cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
		CascadeType.REFRESH })
	@JoinTable(name = "album_user", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name =  "album_id"))
	List<Album> albums = new ArrayList<Album>();
	
	@ManyToMany
	@JoinTable(name = "artist_user", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name =  "artist_id"))
	List<Artist> artists = new ArrayList<Artist>();
	
	@ManyToMany
	@JoinTable(name = "song_user", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name =  "song_id"))
	List<Song> songs = new ArrayList<Song>();
}

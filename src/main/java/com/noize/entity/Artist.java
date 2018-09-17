package com.noize.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.noize.entity.enumeration.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "artist", indexes = @Index(columnList = "artist_name"))
public class Artist extends BaseEntity{

	
	@Column(name = "artist_name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
//	@Column(name = "image_path")
//	private String imagePath;
	
	@Column(name = "genre")
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Column(name = "artist_image")
	private String artistImage;
	
	@OneToMany(mappedBy = "artist")
	List<Album> albums = new ArrayList<Album>();
	
//	@OneToMany(mappedBy = "artist")
//	List<Album> songs = new ArrayList<Album>();
	
	@ManyToMany
	@JoinTable(name = "artist_song",
	joinColumns = @javax.persistence.JoinColumn(name = "artist_id"),
	inverseJoinColumns = @javax.persistence.JoinColumn(name = "song_id"))
	List<Song> songs = new ArrayList<Song>();
	
	@ManyToMany
	@JoinTable(name = "artist_user", 
	joinColumns = @JoinColumn(name = "artist_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id" ))
	List<UserEntity> users = new ArrayList<UserEntity>();
	
	
	@Column(name = "score_rating")
	private int scoreRating;
	
	
//	public int increaseScore(){
//		return this.scoreRating+1;
//	}
//
//
//	public void setssScoreRating(int scoreRating) {
//		this.scoreRating = scoreRating+1;
//	}
//	@ManyToMany
//	@JoinTable(name = "artist_follower",
//	joinColumns = @javax.persistence.JoinColumn(name = "artist_id"),
//	inverseJoinColumns = @javax.persistence.JoinColumn(name = "follower_id"))
//	List<Follower> followers = new ArrayList<Follower>();
	
	

}

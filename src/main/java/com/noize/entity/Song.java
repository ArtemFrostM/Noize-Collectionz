package com.noize.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table (name = "song")
public class Song extends BaseEntity{
	
	@Column(name = "score_rating")
	private int scoreRating = 0;
	
	
	public int increaseScore(){
		return scoreRating++;
	}

	@Column(name = "song_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "album_id")
	private Album album;
	
//	@ManyToOne
//	@JoinColumn(name = "artist_id")
//	private Artist artist;
	
	@ManyToMany
	@JoinTable(name = "artist_song",
	joinColumns = @javax.persistence.JoinColumn(name = "song_id"),
	inverseJoinColumns = @javax.persistence.JoinColumn(name = "artist_id"))
	List<Artist> artists = new ArrayList<Artist>();
	
	@ManyToMany
	@JoinTable(name = "song_user", 
	joinColumns = @JoinColumn(name = "song_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	List<UserEntity> entity = new ArrayList<UserEntity>();




}
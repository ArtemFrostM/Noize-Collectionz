package com.noize.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.noize.domain.AlbumTitleFilter;
import com.noize.entity.enumeration.AlbumType;
import com.noize.entity.enumeration.Genre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "album", indexes = @Index(columnList = "title"))
public class Album extends BaseEntity{
	
	@Column(name = "score_rating")
	private int scoreRating = 0;
	
	
	public int increaseScore(){
		return scoreRating++;
	}

	@Column(name = "title")
	private String title;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "album_image")
	private String albumImage;
	
	@Column(name = "genre")
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Column(name = "album_type")
	@Enumerated(EnumType.STRING)
	private AlbumType albumType;
	
	@ManyToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;
	
	@ManyToMany (cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "album_user", 
	joinColumns = @JoinColumn(name = "album_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	List<UserEntity> users = new ArrayList<UserEntity>();
	
	@OneToMany(mappedBy = "album")
	List<Song> songs = new ArrayList<Song>();

}

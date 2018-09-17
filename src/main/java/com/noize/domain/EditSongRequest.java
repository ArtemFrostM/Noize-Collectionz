package com.noize.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.noize.entity.Album;
import com.noize.entity.Artist;
import com.noize.entity.UserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EditSongRequest {
	private int id;
	private String name;
	private Album album;
	List<Artist> artists;
	List<UserEntity> entity;
}

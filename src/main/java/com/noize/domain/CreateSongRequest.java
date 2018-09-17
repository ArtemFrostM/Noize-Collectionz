package com.noize.domain;


import java.util.List;

import com.noize.entity.Album;
import com.noize.entity.Artist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter @Setter
public class CreateSongRequest {
	private String name;
	private Album album;
	private List<Artist> artists;
}

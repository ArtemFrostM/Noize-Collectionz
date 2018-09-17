package com.noize.domain;

import java.util.List;

import com.noize.entity.Song;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class AddUserToSongRequest {
	private int id;
	private List<Song> songs;
}

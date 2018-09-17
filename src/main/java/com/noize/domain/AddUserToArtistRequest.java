package com.noize.domain;

import java.util.List;

import com.noize.entity.Artist;
import com.noize.entity.Song;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter @Setter
public class AddUserToArtistRequest {
		private Integer id;
		private List<Artist> artists;
}

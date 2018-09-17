package com.noize.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlbumType {
	LP(1),
	EP(2),
	REMIX(3),
	MIXTYPE(4),
	SINGLE(5);
	
	private int id;
}

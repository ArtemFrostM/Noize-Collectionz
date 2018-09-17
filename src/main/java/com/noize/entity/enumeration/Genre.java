package com.noize.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Genre {
	ROCK("Rock",1),
	RAP("Rap",2),
	ALTERNATIVE("Alternative",3),
	POP("Pop",4),
	DISCO("Disco",5),
	TRAP("Trap",6),
	HOUSE("House",7);
	
	private String name;
	private int id;
	
}

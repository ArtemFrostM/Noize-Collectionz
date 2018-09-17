package com.noize.comparators;

import java.util.Comparator;

import com.noize.entity.Artist;

public class ArtistFollowersComparator implements Comparator<Artist>{

	@Override
	public int compare(Artist o1, Artist o2) {
		Artist one = (Artist)o1;
		Artist two = (Artist)o2;
		if(one.getUsers().size()>two.getUsers().size()) {
			return -1;
		} 
		if(one.getUsers().size()<two.getUsers().size()) {
			return 1;
		}
		return 0;
	}

}

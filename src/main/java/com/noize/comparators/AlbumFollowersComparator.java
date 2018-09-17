package com.noize.comparators;

import java.util.Comparator;

import com.noize.entity.Album;

public class AlbumFollowersComparator implements Comparator<Album>{

	@Override
	public int compare(Album o1, Album o2) {
		Album one = (Album)o1;
		Album two = (Album)o2;
		
		if(one.getUsers().size()>two.getUsers().size()) {
			return -1;
		} 
		if(one.getUsers().size()<two.getUsers().size()) {
			return 1;
		}
		return 0;
	}

}

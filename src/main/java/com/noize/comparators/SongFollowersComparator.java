package com.noize.comparators;

import java.util.Comparator;

import com.noize.entity.Song;

public class SongFollowersComparator implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		Song one = (Song)o1;
		Song two = (Song)o2;
		if(one.getEntity().size()>two.getEntity().size()) {
			return -1;
		} 
		if(one.getEntity().size()<two.getEntity().size()) {
			return 1;
		}
		return 0;
	}

}

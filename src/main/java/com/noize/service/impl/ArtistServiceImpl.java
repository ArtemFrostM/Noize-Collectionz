package com.noize.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.noize.domain.ArtistNameFilter;
import com.noize.entity.Artist;
import com.noize.repository.ArtistRepository;
import com.noize.service.ArtistService;

@Service
public class ArtistServiceImpl  implements ArtistService{
	
	@Autowired
	private ArtistRepository repository;

	@Override
	public void saveArtist(Artist artist) {
		repository.save(artist);
	}

	@Override
	public List<Artist> showAllArtists() {
		return repository.findAll();
	}

	@Override
	public Artist findArtistById(int id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Artist> findArtistsByName(Pageable pageable, ArtistNameFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}
	
	private Specification<Artist> getSpecification( ArtistNameFilter filter){
		return new Specification<Artist>() {

			@Override
			public Predicate toPredicate(Root<Artist> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(filter.getSearch().isEmpty()) return null;
				
				return cb.like(root.get("name"), "%" + filter.getSearch() + "%");
			}
		};
	}

	@Override
	public void deleteArtist(int id) {
		repository.delete(id);
	}
	
	
	
	
	

//	@Override
//	public List<Artist> showRapArtists() {
//		return repository.findRapArtists();
//	}

}

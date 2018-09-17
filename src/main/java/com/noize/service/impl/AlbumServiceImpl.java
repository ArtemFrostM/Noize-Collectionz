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

import com.noize.domain.AlbumTitleFilter;
import com.noize.entity.Album;
import com.noize.repository.AlbumRepository;
import com.noize.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumRepository repository;
	
	
	@Override
	public void saveAlbum(Album album) {
		repository.save(album);
	}

	@Override
	public List<Album> showAlbums() {
		return repository.findAll();
	}

	@Override
	public Album findAlbumById(int id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Album> findAllAlbumsByTitle(Pageable pageable, AlbumTitleFilter filter) {
		return repository.findAll(getSpecification(filter), pageable);
	}
	
	private Specification<Album> getSpecification(AlbumTitleFilter filer){
		return new Specification<Album>() {

			@Override
			public Predicate toPredicate(Root<Album> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(filer.getSearch().isEmpty()) return null;
				
				return cb.like(root.get("title"), "%" + filer.getSearch() + "%");
			}
			
		};
	}

	@Override
	public void deleteAlbum(int id) {
		repository.delete(id);
	}
	
}

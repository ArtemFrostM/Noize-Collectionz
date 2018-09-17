package com.noize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noize.entity.Artist;
import com.noize.entity.enumeration.Genre;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>, JpaSpecificationExecutor<Artist>{
//	@Query("SELECT a FROM Artist a WHERE a.genre = com.noize.entity.enumeration.Genre.RAP")
//	Artist findRapArtists(@Param("genre") Genre genre);
	
	@Query("SELECT a FROM Artist a WHERE a.name = :name")
	Artist findArtistByName(@Param("name") String name);
}


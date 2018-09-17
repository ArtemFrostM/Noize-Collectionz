package com.noize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noize.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer>, JpaSpecificationExecutor<Album>{
	@Query("SELECT a FROM Album a WHERE a.title = :title")
	Album findAlbumByTitle(@Param("title") String title);
}

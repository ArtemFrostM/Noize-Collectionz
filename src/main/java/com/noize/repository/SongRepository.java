package com.noize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noize.entity.Song;
import com.noize.entity.UserEntity;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{
//	@Query("SELECT s FROM Song s WHERE s.id = :id")
//	Song findSongById(@Param("id") int id);
}

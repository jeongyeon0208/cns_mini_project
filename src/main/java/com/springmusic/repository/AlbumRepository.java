package com.springmusic.repository;


import com.springmusic.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepository extends JpaRepository<Album, Long> {

}
package com.springmusic.service;

import com.springmusic.domain.Album;
import com.springmusic.dto.AlbumRequest;
import com.springmusic.dto.AlbumResponse;
import com.springmusic.dto.SongRequest;
import com.springmusic.dto.SongResponse;

import java.util.List;

public interface MusicService {

    Long saveAlbum(AlbumRequest albumRequest);
    void saveSong(SongRequest songRequest, Album album);

    void addAlbumSong(Long albumId, SongRequest songRequest);

    List<AlbumResponse> selectAlbumList();
    AlbumResponse selectAlbum(Long albumId);
    List<SongResponse> selectSongList();
    SongResponse selectSong(Long songId);

    void updateAlbum(Long albumId, AlbumRequest albumRequest);
    void updateSong(Long songId, SongRequest songRequest);

    void deleteAlbum(Long albumId);
    void deleteSong(Long songId);


}

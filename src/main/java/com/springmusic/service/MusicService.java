package com.springmusic.service;

import com.springmusic.dto.AlbumDto;
import com.springmusic.dto.SongDto;

import java.util.List;

public interface MusicService {

    List<AlbumDto> selectAlbumList();
    AlbumDto selectAlbum(int albumId);

    List<SongDto> selectSongs();
    SongDto selectSong(int songId);

    Long saveAlbum(AlbumDto albumDto);
    Long saveSong(SongDto songDto);

    void updateAlbum(AlbumDto albumDto);
    void updateSong(SongDto songDto);

    void deleteAlbum(int albumId);
    void deleteSong(int songId);


}

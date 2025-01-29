package com.springmusic.mapper;

import com.springmusic.dto.AlbumDto;
import com.springmusic.dto.SongDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicMapper {
    List<AlbumDto> selectAlbumList();
    List<SongDto> selectSongList();

    void insertAlbum(AlbumDto musicRegisterRequest);
    void insertSong(SongDto songDto);

    AlbumDto selectAlbum(int albumId);
    List<SongDto> selectAlbumSongs(int albumId);

    SongDto selectSong(int songId);

    void updateAlbum(AlbumDto albumDto);
    void updateSong(SongDto songDto);

    void deleteAlbum(int albumId);
    void deleteAlbumSongs(int albumId);
    void deleteSong(int songId);
}

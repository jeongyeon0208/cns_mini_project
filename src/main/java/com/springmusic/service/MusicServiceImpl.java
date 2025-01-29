package com.springmusic.service;

import com.springmusic.dto.AlbumDto;
import com.springmusic.dto.SongDto;
import com.springmusic.mapper.MusicMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<AlbumDto> selectAlbumList() {
        log.info("selectAlbumList");
        return musicMapper.selectAlbumList();
    }

    @Override
    public Long saveAlbum(AlbumDto albumDto) {
        log.info("saveMusic");
        musicMapper.insertAlbum(albumDto);
        for(SongDto songDto : albumDto.getSongList()) {
            songDto.setSongAlbumId(albumDto.getAlbumId());
            musicMapper.insertSong(songDto);
        }

        return albumDto.getAlbumId();
    }

    @Override
    public Long saveSong(SongDto songDto) {
        musicMapper.insertSong(songDto);
        return songDto.getSongId();
    }

    @Override
    public void updateAlbum(AlbumDto albumDto) {
        musicMapper.updateAlbum(albumDto);
    }

    @Override
    public void updateSong(SongDto songDto) {
        musicMapper.updateSong(songDto);
    }

    @Override
    public void deleteAlbum(int albumId) {
        musicMapper.deleteAlbum(albumId);
    }

    @Override
    public void deleteSong(int songId) {
        musicMapper.deleteSong(songId);
    }

    @Override
    public AlbumDto selectAlbum(int albumId) {
        AlbumDto albumDto = musicMapper.selectAlbum(albumId);
        albumDto.setSongList(musicMapper.selectAlbumSongs(albumId));
        return albumDto;
    }

    @Override
    public List<SongDto> selectSongs() {
        return musicMapper.selectSongList();
    }

    @Override
    public SongDto selectSong(int songId) {
        return musicMapper.selectSong(songId);
    }
}

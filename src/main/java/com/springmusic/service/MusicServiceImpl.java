package com.springmusic.service;

import com.springmusic.domain.Album;
import com.springmusic.domain.Song;
import com.springmusic.dto.AlbumRequest;
import com.springmusic.dto.AlbumResponse;
import com.springmusic.dto.SongRequest;
import com.springmusic.dto.SongResponse;
import com.springmusic.repository.AlbumRepository;
import com.springmusic.repository.SongRepository;
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
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;

    @Override
    public Long saveAlbum(AlbumRequest albumRequest) {
        Album album = Album.builder()
                .name(albumRequest.getName())
                .titleSong(albumRequest.getTitleSong())
                .releaseDate(albumRequest.getReleaseDate())
                .genre(albumRequest.getGenre())
                .trackNumber(albumRequest.getTrackNumber())
                .artist(albumRequest.getArtist())
                .build();
        albumRepository.save(album);

        albumRequest.getSongRequestList().forEach(songRequest -> {
            saveSong(songRequest, album);
        });

        return album.getId();
    }

    @Override
    public void saveSong(SongRequest songRequest, Album album) {
        Song song = Song.builder()
                .name(songRequest.getName())
                .lyrics(songRequest.getLyrics())
                .genre(songRequest.getGenre())
                .length(songRequest.getLength())
                .trackNumber(songRequest.getTrackNumber())
                .artist(songRequest.getArtist())
                .album(album)
                .build();
        songRepository.save(song);
    }

    @Override
    public void addAlbumSong(Long albumId, SongRequest songRequest) {
        Album album = albumRepository.findById(albumId).orElseThrow();
        saveSong(songRequest, album);
    }


    @Override
    public List<AlbumResponse> selectAlbumList() {
        return albumRepository.findAll().stream().map(AlbumResponse::of).toList();
    }


    @Override
    public AlbumResponse selectAlbum(Long albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow();
        return AlbumResponse.of(album);
    }

    @Override
    public List<SongResponse> selectSongList() {
        return songRepository.findAll().stream().map(SongResponse::of).toList();
    }

    @Override
    public SongResponse selectSong(Long songId) {
        Song song = songRepository.findById(songId).orElseThrow();
        return SongResponse.of(song);
    }

    @Override
    public void updateAlbum(Long albumId, AlbumRequest albumRequest) {
        Album album = albumRepository.findById(albumId).orElseThrow();
        album.updateAlbum(albumRequest.getName(), albumRequest.getTitleSong(), albumRequest.getReleaseDate(), albumRequest.getGenre(), albumRequest.getTrackNumber(), albumRequest.getArtist());
    }

    @Override
    public void updateSong(Long songId, SongRequest songRequest) {
        Song song = songRepository.findById(songId).orElseThrow();
        song.updateSong(songRequest.getName(), songRequest.getLyrics(), songRequest.getGenre(), songRequest.getLength(), songRequest.getTrackNumber(), songRequest.getArtist());
    }

    @Override
    public void deleteAlbum(Long albumId) {
    }

    @Override
    public void deleteSong(Long songId) {
    }
}

package com.springmusic.controller;

import com.springmusic.dto.AlbumRequest;
import com.springmusic.dto.AlbumResponse;
import com.springmusic.dto.SongRequest;
import com.springmusic.dto.SongResponse;
import com.springmusic.service.MusicService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping("/album")
    @Operation(summary = "새 앨범 저장", description = "새 앨범 저장")
    public ResponseEntity<?> saveAlbum(@RequestBody AlbumRequest albumRequest) {
        Long albumId = musicService.saveAlbum(albumRequest);
        return ResponseEntity.ok(albumId);
    }

    @PostMapping("/song")
    @Operation(summary = "앨범에 추가할 노래 저장", description = "노래 저장")
    public ResponseEntity<?> addAlbumSong(@Param("albumId") Long albumId,
                                      @RequestBody SongRequest songRequest) {
        musicService.addAlbumSong(albumId, songRequest);
        return ResponseEntity.ok("노래 추가 완료");
    }

    @GetMapping("/album")
    @Operation(summary = "전체 앨범 리스트 조회", description = "앨범 리스트 조회")
    public ResponseEntity<?> getAlbums() {
        List<AlbumResponse> albumResponses = musicService.selectAlbumList();
        return ResponseEntity.ok(albumResponses);
    }

    @GetMapping("/album/{albumId}")
    public ResponseEntity<?> getAlbum(@PathVariable Long albumId) {
        AlbumResponse albumResponse = musicService.selectAlbum(albumId);
        return ResponseEntity.ok(albumResponse);
    }

    @GetMapping("/song")
    public ResponseEntity<?> getSongs() {
        List<SongResponse> songResponses = musicService.selectSongList();
        return ResponseEntity.ok(songResponses);
    }

    @GetMapping("/song/{songId}")
    public ResponseEntity<?> getSong(@PathVariable Long songId) {
        return ResponseEntity.ok(musicService.selectSong(songId));
    }


    @PatchMapping("/album/{albumId}")
    public ResponseEntity<?> updateAlbum(@PathVariable Long albumId, AlbumRequest albumRequest) {
        musicService.updateAlbum(albumId, albumRequest);
        return ResponseEntity.ok("앨범 수정 완료");
    }

    @PatchMapping("/song/{songId}")
    public ResponseEntity<?> updateSong(@PathVariable Long songId, SongRequest songRequest) {
        musicService.updateSong(songId, songRequest);
        return ResponseEntity.ok("노래 수정 완료");
    }

    @DeleteMapping("/album/{albumId}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long albumId) {
        musicService.deleteAlbum(albumId);
        return ResponseEntity.ok("앨범 삭제 완료");
    }

    @DeleteMapping("/song/{songId}")
    public ResponseEntity<?> deleteSong(@PathVariable Long songId) {
        musicService.deleteSong(songId);
        return ResponseEntity.ok("노래 삭제 완료");
    }


}

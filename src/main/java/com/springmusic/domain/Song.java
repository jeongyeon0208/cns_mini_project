package com.springmusic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lyrics;
    private String genre;
    private String length;
    private int trackNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    private String artist;

    @Builder
    public Song(String name, String lyrics, String genre, String length, int trackNumber, Album album, String artist) {
        this.name = name;
        this.lyrics = lyrics;
        this.genre = genre;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
        this.artist = artist;
    }

    public void updateSong(String name, String lyrics, String genre, String length, int trackNumber, String artist) {
        this.name = name;
        this.lyrics = lyrics;
        this.genre = genre;
        this.length = length;
        this.trackNumber = trackNumber;
        this.artist = artist;
    }
}

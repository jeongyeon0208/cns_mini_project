package com.springmusic.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String titleSong;
    private LocalDate releaseDate;
    private String genre;
    private int trackNumber;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songList;

    private String artist;

    @Builder
    public Album(String name, String titleSong, LocalDate releaseDate, String genre, int trackNumber, List<Song> songList, String artist) {
        this.name = name;
        this.titleSong = titleSong;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.trackNumber = trackNumber;
        this.songList = songList;
        this.artist = artist;
    }

    public void updateAlbum(String albumName, String titleSong, LocalDate releaseDate, String genre, int trackNumber, String artist) {
        this.name = albumName;
        this.titleSong = titleSong;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.trackNumber = trackNumber;
        this.artist = artist;
    }

}

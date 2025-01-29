package com.springmusic.dto;

import lombok.Data;

import java.util.List;

@Data
public class AlbumDto {

    private Long albumId;
    private String albumName;
    private String titleSong;
    private String releaseDate;
    private String genre;
    private String trackNumber;
    private List<SongDto> songList;
    private String artist;

}

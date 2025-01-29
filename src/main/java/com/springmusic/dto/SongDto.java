package com.springmusic.dto;

import lombok.Data;

@Data
public class SongDto {

    private Long songId;
    private String songName;
    private String songLyrics;
    private String songGenre;
    private String songLength;
    private int songTrackNumber;

    private Long songAlbumId;
    private String artist;
}

package com.springmusic.dto;

import com.springmusic.domain.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongResponse {

    private Long songId;
    private String name;
    private String lyrics;
    private String genre;
    private String length;
    private int trackNumber;

    private Long albumId;
    private String artist;

    public static SongResponse of(Song song) {
        return SongResponse.builder()
                .songId(song.getId())
                .name(song.getName())
                .lyrics(song.getLyrics())
                .genre(song.getGenre())
                .length(song.getLength())
                .trackNumber(song.getTrackNumber())
                .albumId(song.getAlbum().getId())
                .artist(song.getArtist())
                .build();
    }
}

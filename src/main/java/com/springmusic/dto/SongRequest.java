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
public class SongRequest {

    private String name;
    private String lyrics;
    private String genre;
    private String length;
    private int trackNumber;

    private String artist;

    public static SongRequest of(Song song) {
        return SongRequest.builder()
                .name(song.getName())
                .lyrics(song.getLyrics())
                .genre(song.getGenre())
                .length(song.getLength())
                .trackNumber(song.getTrackNumber())
                .artist(song.getArtist())
                .build();
    }
}

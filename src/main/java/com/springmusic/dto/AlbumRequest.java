package com.springmusic.dto;

import com.springmusic.domain.Album;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumRequest {

    private String name;
    private String titleSong;
    private LocalDate releaseDate;
    private String genre;
    private int trackNumber;
    private List<SongRequest> songRequestList;
    private String artist;

    public static AlbumRequest of(Album album) {
        return AlbumRequest.builder()
                .name(album.getName())
                .titleSong(album.getTitleSong())
                .releaseDate(album.getReleaseDate())
                .genre(album.getGenre())
                .trackNumber(album.getTrackNumber())
                .songRequestList(album.getSongList().stream().map(SongRequest::of).toList())
                .artist(album.getArtist())
                .build();
    }

}

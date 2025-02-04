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
public class AlbumResponse {

    private Long albumId;
    private String name;
    private String titleSong;
    private LocalDate releaseDate;
    private String genre;
    private int trackNumber;
    private List<SongResponse> songList;
    private String artist;

    public static AlbumResponse of(Album album) {
        return AlbumResponse.builder()
                .albumId(album.getId())
                .name(album.getName())
                .titleSong(album.getTitleSong())
                .releaseDate(album.getReleaseDate())
                .genre(album.getGenre())
                .trackNumber(album.getTrackNumber())
                .songList(album.getSongList().stream().map(SongResponse::of).toList())
                .artist(album.getArtist())
                .build();
    }

}

package com.springmusic.controller;

import com.springmusic.dto.AlbumDto;
import com.springmusic.dto.SongDto;
import com.springmusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/album")
    public ModelAndView getAlbums() {
        ModelAndView mv = new ModelAndView("albumList");
        mv.addObject("albumList", musicService.selectAlbumList());
        return mv;
    }

    @GetMapping("/album/{albumId}")
    public ModelAndView getAlbum(@PathVariable int albumId) {
        ModelAndView mv = new ModelAndView("album");
        mv.addObject("album", musicService.selectAlbum(albumId));
        return mv;
    }

    @GetMapping("/song")
    public ModelAndView getSongs() {
        ModelAndView mv = new ModelAndView("songList");
        mv.addObject("songList", musicService.selectSongs());
        return mv;
    }

    @GetMapping("/song/{songId}")
    public ModelAndView getSong(@PathVariable int songId) {
        ModelAndView mv = new ModelAndView("song");
        mv.addObject("song", musicService.selectSong(songId));
        return mv;
    }

    @PostMapping("/album/insert")
    public String saveAlbum(AlbumDto albumDto) {
        Long albumId = musicService.saveAlbum(albumDto);
        return "redirect:/album/" + albumId;
    }

    @GetMapping("/album/insert")
    public String albumInsertForm() {
        return "albumInsert";
    }

    @PostMapping("/album/update/{albumId}")
    public String updateAlbum(@PathVariable int albumId, AlbumDto albumDto) {
        musicService.updateAlbum(albumDto);
        return "redirect:/album/" + albumId;
    }

    @PostMapping("/song/update/{songId}")
    public String updateSong(@PathVariable int songId, SongDto songDto) {
        musicService.updateSong(songDto);
        return "redirect:/song/" + songId;
    }

    @PostMapping("/album/delete/{albumId}")
    public String deleteAlbum(@PathVariable int albumId) {
        musicService.deleteAlbum(albumId);
        return "redirect:/album";
    }

    @PostMapping("/song/delete/{songId}")
    public String deleteSong(@PathVariable int songId) {
        musicService.deleteSong(songId);
        return "redirect:/song";
    }

    @PostMapping("/song")
    public String saveSong(SongDto songDto) {
        musicService.saveSong(songDto);
        return "redirect:/song";
    }

}

package com.dzytsiuk.drivepg.web.controller;

import com.dzytsiuk.drivepg.entity.Album;
import com.dzytsiuk.drivepg.entity.Artist;
import com.dzytsiuk.drivepg.service.DeezerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlbumController {
    private final DeezerService deezerService;

    @Autowired
    public AlbumController(DeezerService deezerService) {
        this.deezerService = deezerService;
    }

    @RequestMapping(value = "/album", method = RequestMethod.POST)
    @ResponseBody
    public void saveAlbum(@RequestParam String artist, @RequestParam String name
            , @RequestParam String picture) {
        Album album = new Album(name, new Artist(artist), picture);
        deezerService.saveAlbum(album);
    }
}

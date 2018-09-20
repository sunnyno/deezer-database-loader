package com.dzytsiuk.drivepg.web.controller;

import com.dzytsiuk.drivepg.entity.Album;
import com.dzytsiuk.drivepg.entity.Artist;
import com.dzytsiuk.drivepg.entity.Song;
import com.dzytsiuk.drivepg.service.DeezerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SongController {
    private final DeezerService deezerService;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    public SongController(DeezerService deezerService) {
        this.deezerService = deezerService;
    }

    @RequestMapping(value = "/song", method = RequestMethod.POST)
    @ResponseBody
    public void saveSong(@RequestParam String title, @RequestParam String picture,
                         @RequestParam String album, @RequestParam String artist,
                         @RequestParam String data, @RequestParam(value = "genres[]") List<String> genres) {
        List<Artist> artists = new ArrayList<>();
        Artist artistObj = new Artist(artist);
        artists.add(artistObj);
        Album albumObj = new Album(album, artistObj);
        albumObj.setGenres(genres);
        Song song = Song.builder()
                .withTitle(title)
                .withArtists(artists)
                .withAlbum(albumObj)
                .withPicture(picture)
                .withData(data)
                .build();
        logger.info("Saving song {}", song);
        deezerService.saveSong(song);
    }


}

package com.dzytsiuk.drivepg.web.controller;

import com.dzytsiuk.drivepg.entity.Artist;
import com.dzytsiuk.drivepg.service.DeezerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArtistController {
    private final DeezerService deezerService;

    @Autowired
    public ArtistController(DeezerService deezerService) {
        this.deezerService = deezerService;
    }

    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    @ResponseBody
    public void saveArtist(@RequestParam String name, @RequestParam String picture) {
        deezerService.saveArtist(new Artist(name, picture));
    }
}

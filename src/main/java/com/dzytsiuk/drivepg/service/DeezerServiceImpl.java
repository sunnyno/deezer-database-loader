package com.dzytsiuk.drivepg.service;

import com.dzytsiuk.drivepg.dao.DeezerDao;
import com.dzytsiuk.drivepg.entity.Album;
import com.dzytsiuk.drivepg.entity.Artist;
import com.dzytsiuk.drivepg.entity.Song;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DeezerServiceImpl implements DeezerService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DeezerDao deezerDao;
    @Autowired
    GoogleDriveService googleDriveService;

    @Override
    public void saveSong(Song song) {
        File mp3 = getMp3(song.getData(), song.getTitle() + ".mp3");
        String googleMp3 = googleDriveService.getGoogleMp3FromFile(mp3);
        logger.info("Google drive url for song {} is {}", song.getTitle(), googleMp3);
        song.setData(googleMp3);
        mp3.delete();
        deezerDao.saveSong(song);
    }

    private File getMp3(String url, String fileName) {
        try {
            URLConnection connection = new URL(url).openConnection();
            Path mp3 = Paths.get("/tmp/" + fileName);
            try (InputStream is = connection.getInputStream()) {
                Files.copy(is, mp3);
                return mp3.toFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to download file ", e);
        }

    }


    @Override
    public void saveArtist(Artist artist) {
        deezerDao.saveArtist(artist);
    }

    @Override
    public void saveAlbum(Album album) {
        deezerDao.saveAlbum(album);
    }
}

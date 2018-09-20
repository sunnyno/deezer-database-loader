package com.dzytsiuk.drivepg.service;

import com.dzytsiuk.drivepg.entity.Album;
import com.dzytsiuk.drivepg.entity.Artist;
import com.dzytsiuk.drivepg.entity.Song;

public interface DeezerService {
     void saveSong(Song song);

    void saveArtist(Artist artist);

    void saveAlbum(Album album);
}

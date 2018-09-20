package com.dzytsiuk.drivepg.dao;

import com.dzytsiuk.drivepg.entity.Album;
import com.dzytsiuk.drivepg.entity.Artist;
import com.dzytsiuk.drivepg.entity.Song;

public interface DeezerDao {
    void saveSong(Song song);

    void saveArtist(Artist artist);

    void saveAlbum(Album album);
}

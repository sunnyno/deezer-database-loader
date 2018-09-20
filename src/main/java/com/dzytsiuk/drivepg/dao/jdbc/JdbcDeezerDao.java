package com.dzytsiuk.drivepg.dao.jdbc;

import com.dzytsiuk.drivepg.dao.DeezerDao;
import com.dzytsiuk.drivepg.entity.Album;
import com.dzytsiuk.drivepg.entity.Artist;
import com.dzytsiuk.drivepg.entity.Song;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcDeezerDao implements DeezerDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String SAVE_SONG = "insert into song(title, track_url, album, picture_link)" +
            " select ?, ?, id, ? from album where title = ? and artist = (select id from artist where name = ?) " +
            "ON CONFLICT DO NOTHING";
    private static final String SAVE_ARTIST = "insert into artist (name, picture) values(?,?) ON CONFLICT DO NOTHING";
    private static final String SAVE_ALBUM = "insert into album(title, artist, picture_link) " +
            "select ?, id, ? from artist where name = ? ON CONFLICT DO NOTHING";
    private static final String SAVE_GENRE = "insert into genre(title) values(?)  ON CONFLICT DO NOTHING";
    private static final String SAVE_SONG_GENRES = "insert into song_genre(song, genre)" +
            " values ((select id from song where title = ?" +
            " and album = (select id from album where title = ?))," +
            " (select id from genre where title =? )) ON CONFLICT DO NOTHING";

    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void saveSong(Song song) {
        logger.info("Saving song {}", song);
        jdbcTemplateObject.update(SAVE_SONG, song.getTitle(), song.getData(), song.getPicture()
                , song.getAlbum().getTitle()
                , song.getAlbum().getArtist().getName());
        for (String genre : song.getAlbum().getGenres()) {
            jdbcTemplateObject.update(SAVE_GENRE, genre);
            jdbcTemplateObject.update(SAVE_SONG_GENRES, song.getTitle(), song.getAlbum().getTitle(), genre);
        }

    }

    @Override
    public void saveArtist(Artist artist) {
        logger.info("Saving artist {}", artist);
        jdbcTemplateObject.update(SAVE_ARTIST, artist.getName(), artist.getPicture());
    }

    @Override
    public void saveAlbum(Album album) {
        logger.info("Saving album {}", album);
        jdbcTemplateObject.update(SAVE_ALBUM, album.getTitle(), album.getPicture(), album.getArtist().getName());
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
}

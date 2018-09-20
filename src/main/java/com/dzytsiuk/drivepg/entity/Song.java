package com.dzytsiuk.drivepg.entity;

import java.util.List;
import java.util.Objects;

public class Song {
    private String title;
    private String data;
    private Album album;
    private String picture;
    private List<Artist> artists;


    public Song(String title, String data, Album album, String picture, List<Artist> artists) {
        this.title = title;
        this.data = data;
        this.album = album;
        this.picture = picture;
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) &&
                Objects.equals(data, song.data) &&
                Objects.equals(album, song.album) &&
                Objects.equals(picture, song.picture) &&
                Objects.equals(artists, song.artists);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, data, album, picture, artists);
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", album=" + album +
                ", picture='" + picture + '\'' +
                ", artists=" + artists +
                '}';
    }

    public static SongBuilder builder() {
        return new SongBuilder();
    }


    public static class SongBuilder {
        private String title;
        private String data;
        private Album album;
        private String picture;
        private List<Artist> artists;

        public SongBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public SongBuilder withData(String data) {
            this.data = data;
            return this;
        }

        public SongBuilder withAlbum(Album album) {
            this.album = album;
            return this;
        }

        public SongBuilder withArtists(List<Artist> artists) {
            this.artists = artists;
            return this;
        }

        public SongBuilder withPicture(String picture) {
            this.picture = picture;
            return this;
        }


        public Song build() {
            return new Song(title, data, album, picture, artists);
        }

    }
}

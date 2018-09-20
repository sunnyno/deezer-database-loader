package com.dzytsiuk.drivepg.entity;

import java.util.List;
import java.util.Objects;

public class Album {
    private String title;
    private Artist artist;
    private String picture;
    private List<String> genres;

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }

    public Album(String title, Artist artist, String picture) {
        this.title = title;
        this.artist = artist;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(title, album.title) &&
                Objects.equals(artist, album.artist) &&
                Objects.equals(picture, album.picture) &&
                Objects.equals(genres, album.genres);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, artist, picture, genres);
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist=" + artist +
                ", picture='" + picture + '\'' +
                ", genres=" + genres +
                '}';
    }
}

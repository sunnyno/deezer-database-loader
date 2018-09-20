package com.dzytsiuk.drivepg.entity;

import java.util.Objects;

public class Artist {
    private String name;
    private String picture;

    public Artist(String name, String picture) {
        this.name = name;
        this.picture = picture;
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name) &&
                Objects.equals(picture, artist.picture);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, picture);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}

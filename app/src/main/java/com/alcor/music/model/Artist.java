package com.alcor.music.model;

public class Artist {

    private String artistID, name, thumbnail, bio, genre, genreID;
    private int rating, subscribers;


    public String getArtistID() {
        return artistID;
    }

    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenreID() {
        return genreID;
    }

    public void setGenreID(String genreID) {
        this.genreID = genreID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }
}

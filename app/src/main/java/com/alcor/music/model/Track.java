package com.alcor.music.model;

public class Track {

    private String trackID, title, artistID, artistName, description, thumbnail, uploadDate,
            releaseDate, genre, genreID, trackNumber;
    private double duration, rating;
    private int downloadCount;

    public Track() {

    }

    public Track(String trackID, String title, String artistID, String artistName,
                 String description, String thumbnail, String uploadDate, String releaseDate,
                 String genre, String genreID, String trackNumber, double duration, double rating,
                 int downloadCount) {
        this.trackID = trackID;
        this.title = title;
        this.artistID = artistID;
        this.artistName = artistName;
        this.description = description;
        this.thumbnail = thumbnail;
        this.uploadDate = uploadDate;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.genreID = genreID;
        this.trackNumber = trackNumber;
        this.duration = duration;
        this.rating = rating;
        this.downloadCount = downloadCount;
    }

    public String getTrackID() {
        return trackID;
    }

    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistID() {
        return artistID;
    }

    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }
}

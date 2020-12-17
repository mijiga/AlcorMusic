package com.alcor.music.model;

public class Album {

    private String albumID, name, artistID, artistName, uploadDate, releaseDate;
    private String thumbnail, description, genre, genreID;
    private int downloadCount, price;
    private double rating;

    public Album() {

    }

    public Album(String albumID, String name, String artistID, String artistName, String uploadDate, String releaseDate, String thumbnail, String description, String genre, String genreID, int downloadCount, int price, double rating) {
        this.albumID = albumID;
        this.name = name;
        this.artistID = artistID;
        this.artistName = artistName;
        this.uploadDate = uploadDate;
        this.releaseDate = releaseDate;
        this.thumbnail = thumbnail;
        this.description = description;
        this.genre = genre;
        this.genreID = genreID;
        this.downloadCount = downloadCount;
        this.price = price;
        this.rating = rating;
    }

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

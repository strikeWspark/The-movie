package com.dryfire.themovie.Modal;

import java.io.Serializable;

public class TheMovie implements Serializable {



    private boolean adult;
    private String backdrop_path;
    private int id;
    private String title;
    private String release_date;
    private String overview;
    private String rating;

    public TheMovie() {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.overview = overview;
        this.rating = rating;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

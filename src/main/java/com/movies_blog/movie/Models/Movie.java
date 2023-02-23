package com.movies_blog.movie.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "movies")
public class Movie {
    public Movie() {

    }

    public Movie(Integer id, String title, String genres, String original_language, String overview, Float popularity, String production_companies, Date release_date, Double budget, Double revenue, Double runtime, String status, String tagline, Double vote_average, Double vote_count, String credits, String keywords, String poster_path, String backdrop_path, String recommendations) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.original_language = original_language;
        this.overview = overview;
        this.popularity = popularity;
        this.production_companies = production_companies;
        this.release_date = release_date;
        this.budget = budget;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.credits = credits;
        this.keywords = keywords;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.recommendations = recommendations;
    }

    @Id
    private Integer id;
    private String title;
    private String genres;
    private String original_language;
    private String overview;
    private Float popularity;
    private String production_companies;
    private Date release_date;
    private Double budget;
    private Double revenue;
    private Double runtime;
    private String status;
    private String tagline;
    private Double vote_average;
    private Double vote_count;
    private String credits;
    private String keywords;
    private String poster_path;
    private String backdrop_path;
    private String recommendations;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(String production_companies) {
        this.production_companies = production_companies;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getRuntime() {
        return runtime;
    }

    public void setRuntime(Double runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public Double getVote_count() {
        return vote_count;
    }

    public void setVote_count(Double vote_count) {
        this.vote_count = vote_count;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", original_language='" + original_language + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", production_companies='" + production_companies + '\'' +
                ", release_date=" + release_date +
                ", budget=" + budget +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                ", credits='" + credits + '\'' +
                ", keywords='" + keywords + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", recommendations='" + recommendations + '\'' +
                '}';
    }

}

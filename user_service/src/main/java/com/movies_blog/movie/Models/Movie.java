package com.movies_blog.movie.Models;

import jakarta.persistence.Column;
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
        this.originalLanguage = original_language;
        this.overview = overview;
        this.popularity = popularity;
        this.productionCompanies = production_companies;
        this.releaseDate = release_date;
        this.budget = budget;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.voteAverage = vote_average;
        this.voteCount = vote_count;
        this.credits = credits;
        this.keywords = keywords;
        this.posterPath = poster_path;
        this.backdropPath = backdrop_path;
        this.recommendations = recommendations;
    }

    @Id
    private Integer id;
    private String title;
    private String genres;
    @Column(name = "original_language")
    private String originalLanguage;
    private String overview;
    private Float popularity;
    @Column(name = "production_companies")
    private String productionCompanies;
    @Column(name = "release_date")
    private Date releaseDate;
    private Double budget;
    private Double revenue;
    private Double runtime;
    private String status;
    private String tagline;
    @Column(name = "vote_average")
    private Double voteAverage;
    @Column(name = "vote_count")
    private Double voteCount;
    private String credits;
    private String keywords;
    @Column(name = "poster_path")
    private String posterPath;
    @Column(name = "backdrop_path")
    private String backdropPath;
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

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
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

    public String getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(String productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Double getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Double voteCount) {
        this.voteCount = voteCount;
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

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
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
                ", original_language='" + originalLanguage + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", production_companies='" + productionCompanies + '\'' +
                ", release_date=" + releaseDate +
                ", budget=" + budget +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", vote_average=" + voteAverage +
                ", vote_count=" + voteCount +
                ", credits='" + credits + '\'' +
                ", keywords='" + keywords + '\'' +
                ", poster_path='" + posterPath + '\'' +
                ", backdrop_path='" + backdropPath + '\'' +
                ", recommendations='" + recommendations + '\'' +
                '}';
    }

}

package com.movies_blog.movie.Models;

public class MovieCount {
    private Long count;

    public MovieCount(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    private String listName = "Movie List";
}

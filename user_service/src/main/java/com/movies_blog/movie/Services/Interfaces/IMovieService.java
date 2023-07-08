package com.movies_blog.movie.Services.Interfaces;

import com.movies_blog.movie.Models.Movie;
import com.movies_blog.movie.Models.MovieCount;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.concurrent.CompletableFuture;

public interface IMovieService {
    public CollectionModel<EntityModel<Movie>> getAllMovies();

    public CollectionModel<EntityModel<Movie>> getMoviesByStartAndEndIndex(int pageNumber, int itemPerPage, String sortBy, String direction);

    public EntityModel<Movie> getMovieById(Long id);

    public EntityModel<MovieCount> getMovieCount();

    public CompletableFuture<CollectionModel<EntityModel<Movie>>> getAllMoviesAsync();

    public CompletableFuture<CollectionModel<EntityModel<Movie>>> getMoviesByStartAndEndIndexAsync(int pageNumber, int itemPerPage);

    public CompletableFuture<EntityModel<Movie>> getMovieByIdAsync(Long id);

}

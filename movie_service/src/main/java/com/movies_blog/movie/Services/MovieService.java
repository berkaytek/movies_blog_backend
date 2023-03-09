package com.movies_blog.movie.Services;

import com.movies_blog.movie.Controllers.MovieController;
import com.movies_blog.movie.Models.Movie;
import com.movies_blog.movie.Models.MovieCount;
import com.movies_blog.movie.Models.MovieModelAssembler;
import com.movies_blog.movie.Repository.Exceptions.MovieNotFoundException;
import com.movies_blog.movie.Repository.MovieRepository;
import com.movies_blog.movie.Services.Interfaces.IMovieService;
import com.movies_blog.movie.Services.Interfaces.IMovieSorterService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service("MovieServiceBase")
public class MovieService implements IMovieService {
    private final MovieRepository repository;
    private final MovieModelAssembler movieAssembler;
    private final IMovieSorterService movieSorterService;

    public MovieService(MovieRepository repository, MovieModelAssembler movieAssembler, IMovieSorterService movieSorterService) {
        this.movieAssembler = movieAssembler;
        this.repository = repository;
        this.movieSorterService = movieSorterService;
    }


    @Override
    public CollectionModel<EntityModel<Movie>> getAllMovies() {
        List<EntityModel<Movie>> moviesWithLinks = repository
                .findAll()
                .stream()
                .map(movieAssembler::toModel)
                .collect(Collectors.toList());
        return CollectionModel.of(moviesWithLinks, linkTo(methodOn(MovieController.class).getAll()).withSelfRel());
    }

    @Override
    public CollectionModel<EntityModel<Movie>> getMoviesByStartAndEndIndex(int pageNumber, int itemPerPage, String sortBy, String direction) {
        Sort sort = movieSorterService.getSorter(sortBy, direction);
        PageRequest pageable = PageRequest.of(pageNumber, itemPerPage, sort);

        List<EntityModel<Movie>> moviesWithLinks = repository
                .findAll(pageable)
                .stream()
                .map(movieAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(moviesWithLinks, linkTo(methodOn(MovieController.class).getAll()).withSelfRel());
    }

    @Override
    public EntityModel<Movie> getMovieById(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        return movieAssembler.toModel(movie);
    }

    @Override
    public EntityModel<MovieCount> getMovieCount() {
        MovieCount movieCount = new MovieCount(repository.count());
        
        var entity = EntityModel.of(movieCount,
                linkTo(methodOn(MovieController.class).getCountOfMovies()).withSelfRel(),
                linkTo(methodOn(MovieController.class).getCountOfMovies()).withRel("MovieCount")
        );
        return entity;

    }

    @Override
    @Async
    public CompletableFuture<CollectionModel<EntityModel<Movie>>> getAllMoviesAsync() {
        List<EntityModel<Movie>> moviesWithLinks = repository
                .findAll()
                .stream()
                .map(movieAssembler::toModel)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(CollectionModel.of(moviesWithLinks, linkTo(methodOn(MovieController.class).getAll()).withSelfRel()));
    }

    @Override
    @Async
    public CompletableFuture<CollectionModel<EntityModel<Movie>>> getMoviesByStartAndEndIndexAsync(int pageNumber, int itemPerPage) {
        PageRequest pageable = PageRequest.of(pageNumber, itemPerPage, Sort.by("id").ascending());

        List<EntityModel<Movie>> moviesWithLinks = repository
                .findAll(pageable)
                .stream()
                .map(movieAssembler::toModel)
                .collect(Collectors.toList());

        return CompletableFuture.completedFuture(CollectionModel.of(moviesWithLinks, linkTo(methodOn(MovieController.class).getAll()).withSelfRel()));
    }

    @Override
    @Async
    public CompletableFuture<EntityModel<Movie>> getMovieByIdAsync(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        return CompletableFuture.completedFuture(movieAssembler.toModel(movie));
    }
}

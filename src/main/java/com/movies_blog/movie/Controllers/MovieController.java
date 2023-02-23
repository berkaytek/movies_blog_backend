package com.movies_blog.movie.Controllers;

import com.movies_blog.movie.Models.Movie;
import com.movies_blog.movie.Models.MovieModelAssembler;
import com.movies_blog.movie.Repository.Exceptions.MovieNotFoundException;
import com.movies_blog.movie.Repository.MovieRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class MovieController {
    private final MovieRepository repository;
    private final MovieModelAssembler movieAssembler;

    public MovieController(MovieRepository repository, MovieModelAssembler movieAssembler) {
        this.movieAssembler = movieAssembler;
        this.repository = repository;
    }

    @GetMapping("/movies")
    public CollectionModel<EntityModel<Movie>> getAll() {
        List<EntityModel<Movie>> moviesWithLinks = repository
                .findAll()
                .stream()
                .map(movie -> movieAssembler.toModel(movie))
                .collect(Collectors.toList());
        return CollectionModel.of(moviesWithLinks, linkTo(methodOn(MovieController.class).getAll()).withSelfRel());
    }

    @GetMapping("/movies/{id}")
    public EntityModel<Movie> getOneMovie(@PathVariable Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        return movieAssembler.toModel(movie);
    }

}

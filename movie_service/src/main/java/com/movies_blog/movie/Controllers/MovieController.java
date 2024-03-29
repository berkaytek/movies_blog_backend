package com.movies_blog.movie.Controllers;

import com.movies_blog.common.Entities.Movie;
import com.movies_blog.common.Entities.MovieCount;
import com.movies_blog.movie.Services.Interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class MovieController {

    private final IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/all")
    @ResponseBody
    public CollectionModel<EntityModel<Movie>> getAll() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/get")
    @ResponseBody
    public CollectionModel<EntityModel<Movie>> getMoviesByStartAndEndIndex(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "20") int itemPerPage, @RequestParam(defaultValue = "id", required = false) String sortBy, @RequestParam(defaultValue = "ascending", required = false) String direction) {
        return movieService.getMoviesByStartAndEndIndex(pageNumber, itemPerPage, sortBy, direction);
    }

    @GetMapping("/movies/count")
    @ResponseBody
    public EntityModel<MovieCount> getCountOfMovies() {
        return movieService.getMovieCount();
    }

    @GetMapping("/movies/{id}")
    public EntityModel<Movie> getOneMovie(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

}

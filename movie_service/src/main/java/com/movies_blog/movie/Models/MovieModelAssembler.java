package com.movies_blog.movie.Models;

import com.movies_blog.common.Entities.Movie;
import com.movies_blog.movie.Controllers.MovieController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MovieModelAssembler implements RepresentationModelAssembler<Movie, EntityModel<Movie>> {
    @Override
    public EntityModel<Movie> toModel(Movie movie) {
        return EntityModel.of(movie,
                linkTo(methodOn(MovieController.class).getOneMovie(movie.getId().longValue())).withSelfRel(),
                linkTo(methodOn(MovieController.class).getOneMovie(movie.getId().longValue())).withRel("Movie")
        );
    }
}

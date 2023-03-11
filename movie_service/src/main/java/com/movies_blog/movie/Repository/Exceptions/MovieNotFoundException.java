package com.movies_blog.movie.Repository.Exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(Long id){
        super("Could not find movie " + id.toString());
    }
}

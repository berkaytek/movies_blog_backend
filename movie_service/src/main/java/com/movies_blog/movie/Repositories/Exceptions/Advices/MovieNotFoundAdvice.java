package com.movies_blog.movie.Repositories.Exceptions.Advices;

import com.movies_blog.movie.Repositories.Exceptions.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MovieNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String MovieNotFoundAdvice(MovieNotFoundException ex) {
        return ex.getMessage();
    }
}

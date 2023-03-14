package com.movies_blog.movie.Repositories.Exceptions.Advices;

import com.movies_blog.movie.Repositories.Exceptions.InvalidSortPropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidSortPropertyAdvice {

    @ResponseBody
    @ExceptionHandler(InvalidSortPropertyException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    String InvalidSortPropertyAdvice(InvalidSortPropertyException ex) {
        return ex.getMessage();
    }
}

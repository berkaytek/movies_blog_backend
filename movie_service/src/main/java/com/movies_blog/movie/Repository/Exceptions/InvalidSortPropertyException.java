package com.movies_blog.movie.Repository.Exceptions;

public class InvalidSortPropertyException extends RuntimeException {
    public InvalidSortPropertyException(String sortByPropertyName) {
        super("Property requested for sorting does not exist : " + sortByPropertyName);
    }
}

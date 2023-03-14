package com.movies_blog.movie.Repositories.Exceptions;

public class InvalidSortPropertyException extends RuntimeException {
    public InvalidSortPropertyException(String sortByPropertyName) {
        super("Property requested for sorting does not exist : " + sortByPropertyName);
    }
}

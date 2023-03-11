package com.movies_blog.movie.Services;

import com.movies_blog.movie.Models.Movie;
import com.movies_blog.movie.Repository.Exceptions.InvalidSortPropertyException;
import com.movies_blog.movie.Services.Interfaces.IMovieSorterService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieSorterService implements IMovieSorterService {
    private final List<String> validFields;

    public MovieSorterService() {
        this.validFields = Arrays.stream(Movie.class.getDeclaredFields())
                .map(field -> field.getName())
                .collect(Collectors.toList());
    }

    private boolean isFieldValid(String field) {
        return validFields.contains(field);
    }

    @Override
    public Sort getSorter(String sortBy, String direction) {
        if (!isFieldValid(sortBy)) {
            throw new InvalidSortPropertyException(sortBy);
        }
        Sort sort = Sort.by(sortBy).ascending();
        if (direction.equals("descending")) {
            sort = Sort.by(sortBy).descending();
        }
        return sort;
    }
}

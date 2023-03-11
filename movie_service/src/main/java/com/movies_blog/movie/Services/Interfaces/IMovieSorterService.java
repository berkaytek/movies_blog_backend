package com.movies_blog.movie.Services.Interfaces;

import org.springframework.data.domain.Sort;

public interface IMovieSorterService {
    public Sort getSorter(String sortBy, String direction);
}

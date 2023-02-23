package com.movies_blog.movie.Repository;

import com.movies_blog.movie.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

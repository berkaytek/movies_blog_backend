package com.movies_blog.movie.Repositories;

import com.movies_blog.common.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}

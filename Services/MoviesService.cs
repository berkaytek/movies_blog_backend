using movies_blog_backend.Models;
using movies_blog_backend.Services.Interfaces;
using movies_blog_backend.Repositories.Contexts;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc;

namespace movies_blog_backend.Services;
public class MoviesService : IMoviesService
{
    private readonly MoviesDatabaseContext _context;
    public MoviesService(MoviesDatabaseContext context)
    {
        _context = context;
    }
    
    public async Task<List<MovieMetadataBase>> getAllMovieData()
    {
        var movie_metaDatas = new List<MovieMetadataBase>();
        movie_metaDatas =  await _context.MovieMetadata
        .Select(e=>new MovieMetadataBase(e.Homepage, e.Id, e.PosterPath, e.Title))
        .ToListAsync();
        return movie_metaDatas ;
    }

    public async Task<List<MovieMetadataBase>> getMovieDataByStartAndEndIndex(int startIndex,  int endIndex){
        var movie_metaDatas = _context.MovieMetadata
        .AsQueryable()
        .AsNoTracking()
        .Skip(startIndex)
        .Take(endIndex - startIndex + 1)
        .Select(e=>new MovieMetadataBase(e.Homepage, e.Id, e.PosterPath, e.Title))
        .ToListAsync();
        return await movie_metaDatas;
    }
}
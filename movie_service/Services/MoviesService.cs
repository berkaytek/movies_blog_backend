using movies_blog_backend.Models;
using movies_blog_backend.Services.Interfaces;
using movies_blog_backend.Repositories.Contexts;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc;

namespace movies_blog_backend.Services;
public class MoviesService : IMoviesService
{
    private readonly MovieDatabaseMainContext _context;
    public MoviesService(MovieDatabaseMainContext context)
    {
        _context = context;
    }
    
    public async Task<List<MovieBase>> getAllMovieData()
    {
        var movies = new List<MovieBase>();
        movies =  await _context.Movies
        .Select(e=>new MovieBase(e.Id, e.Title, e.Genres, e.PosterPath, e.Overview))
        .ToListAsync();
        return movies ;
    }

    public async Task<List<MovieBase>> getMovieDataByStartAndEndIndex(int startIndex,  int endIndex){
        var movie_metaDatas = _context.Movies
        .AsQueryable()
        .AsNoTracking()
        .OrderByDescending(x => x.Id)
        .Skip(startIndex)
        .Take(endIndex - startIndex + 1)
        .Select(e=>new MovieBase(e.Id, e.Title, e.Genres, e.PosterPath, e.Overview))
        .ToListAsync();
        return await movie_metaDatas;
    }

    public async Task<int> GetTotalMovieCount() => await _context.Movies.CountAsync();
    
}
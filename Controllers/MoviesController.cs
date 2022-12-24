using Microsoft.AspNetCore.Mvc;
using movies_blog_backend.Services.Interfaces;
using movies_blog_backend.Models;

namespace movies_blog_backend.Controllers;

[ApiController]
[Route("api/[controller]/[action]")]
public class MoviesController : ControllerBase
{
    private readonly IMoviesService _movieService;

    public MoviesController(IMoviesService moviesService)
    {
        _movieService = moviesService;
    }

    //for testing & checking data only
    [HttpGet]
    public async Task<List<MovieBase>> GetAllMovies() => await _movieService.getAllMovieData();

    [HttpGet]
    public async Task<List<MovieBase>> GetMoviesByStartAndEndIndex([FromQuery] int startIndex, [FromQuery] int endIndex) => await _movieService.getMovieDataByStartAndEndIndex(startIndex,endIndex);

    [HttpGet]
    public async Task<int> GetMoviesTotalCount() => await _movieService.GetTotalMovieCount();
}
//([FromQuery] int startIndex, [FromQuery] int endIndex)
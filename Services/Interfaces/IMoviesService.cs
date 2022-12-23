using movies_blog_backend.Models;

namespace movies_blog_backend.Services.Interfaces;
public interface IMoviesService
{
    public Task<List<MovieBase>> getAllMovieData();
    public  Task<List<MovieBase>> getMovieDataByStartAndEndIndex(int startIndex, int endIndex);

}
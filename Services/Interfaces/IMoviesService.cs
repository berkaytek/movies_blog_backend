using movies_blog_backend.Models;

namespace movies_blog_backend.Services.Interfaces;
public interface IMoviesService
{
    public Task<List<MovieMetadataBase>> getAllMovieData();
    public  Task<List<MovieMetadataBase>> getMovieDataByStartAndEndIndex(int startIndex, int endIndex);

}
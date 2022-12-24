namespace movies_blog_backend.Models;


public class MovieBase
{
    public MovieBase(decimal id, string? title, string? genres, string? posterPath, string? overview)
    {
        this.Id = id;
        this.Title = title;
        this.Genres = genres;
        this.PosterPath = posterPath;
        this.Overview = overview;
    }
    public MovieBase()
    {
        
    }

    public decimal Id { get; set; }

    public string? Title { get; set; }

    public string? Genres { get; set; }
    
    public string? PosterPath { get; set; }

    public string? Overview { get; set; }
    
}
namespace movies_blog_backend.Models;

public class MovieMetadataBase
{
    public MovieMetadataBase()
    {
        
    }
    public MovieMetadataBase(string? homepage, string id, string? posterPath, string? title)
    {
        Homepage = homepage;
        Id = id;
        PosterPath = posterPath;
        Title = title;
    }

    public string? Homepage { get; set; }

    public string Id { get; set; } = null!;

    public string? PosterPath { get; set; }

     public string? Title { get; set; }

    
}
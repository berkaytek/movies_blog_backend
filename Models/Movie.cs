using System;
using System.Collections.Generic;

namespace movies_blog_backend;
using movies_blog_backend.Models;



public partial class Movie:MovieBase
{


    public string OriginalLanguage { get; set; } = null!;

    public string? Overview { get; set; }

    public decimal Popularity { get; set; }

    public string? ProductionCompanies { get; set; }

    public DateOnly? ReleaseDate { get; set; }

    public decimal Budget { get; set; }

    public decimal Revenue { get; set; }

    public decimal? Runtime { get; set; }

    public string Status { get; set; } = null!;

    public string? Tagline { get; set; }

    public decimal VoteAverage { get; set; }

    public decimal VoteCount { get; set; }

    public string? Credits { get; set; }

    public string? Keywords { get; set; }

    public string? PosterPath { get; set; }

    public string? BackdropPath { get; set; }

    public string? Recommendations { get; set; }
}

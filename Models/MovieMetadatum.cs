using System;
using System.Collections.Generic;

namespace movies_blog_backend.Models;

public partial class MovieMetadatum:MovieMetadataBase
{
    public string Adult { get; set; } = null!;

    public string? BelongsToCollection { get; set; }

    public string Budget { get; set; } = null!;

    public string Genres { get; set; } = null!;

    public string? ImdbId { get; set; }

    public string? OriginalLanguage { get; set; }

    public string OriginalTitle { get; set; } = null!;

    public string? Overview { get; set; }

    public string? Popularity { get; set; }

    public string? ProductionCompanies { get; set; }

    public string? ProductionCountries { get; set; }

    public string? ReleaseDate { get; set; }

    public decimal? Revenue { get; set; }

    public decimal? Runtime { get; set; }

    public string? SpokenLanguages { get; set; }

    public string? Status { get; set; }

    public string? Tagline { get; set; }

    public bool? Video { get; set; }

    public decimal? VoteAverage { get; set; }

    public decimal? VoteCount { get; set; }
}

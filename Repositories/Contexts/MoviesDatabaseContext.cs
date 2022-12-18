using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using movies_blog_backend.Models;

namespace movies_blog_backend.Repositories.Contexts;

public partial class MoviesDatabaseContext : DbContext
{
    public MoviesDatabaseContext()
    {
    }

    public MoviesDatabaseContext(DbContextOptions<MoviesDatabaseContext> options)
        : base(options)
    {
    }

    public virtual DbSet<MovieMetadatum> MovieMetadata { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        => optionsBuilder.UseNpgsql("Host=192.168.1.40; Database=movies_database; Username=root; Password=root");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<MovieMetadatum>(entity =>
        {
            entity.HasNoKey();

            entity.Property(e => e.Adult)
                .HasColumnType("character varying")
                .HasColumnName("adult");
            entity.Property(e => e.BelongsToCollection)
                .HasColumnType("character varying")
                .HasColumnName("belongs_to_collection");
            entity.Property(e => e.Budget)
                .HasColumnType("character varying")
                .HasColumnName("budget");
            entity.Property(e => e.Genres)
                .HasColumnType("character varying")
                .HasColumnName("genres");
            entity.Property(e => e.Homepage)
                .HasColumnType("character varying")
                .HasColumnName("homepage");
            entity.Property(e => e.Id)
                .HasColumnType("character varying")
                .HasColumnName("id");
            entity.Property(e => e.ImdbId)
                .HasColumnType("character varying")
                .HasColumnName("imdb_id");
            entity.Property(e => e.OriginalLanguage)
                .HasColumnType("character varying")
                .HasColumnName("original_language");
            entity.Property(e => e.OriginalTitle)
                .HasColumnType("character varying")
                .HasColumnName("original_title");
            entity.Property(e => e.Overview)
                .HasColumnType("character varying")
                .HasColumnName("overview");
            entity.Property(e => e.Popularity)
                .HasColumnType("character varying")
                .HasColumnName("popularity");
            entity.Property(e => e.PosterPath)
                .HasColumnType("character varying")
                .HasColumnName("poster_path");
            entity.Property(e => e.ProductionCompanies)
                .HasColumnType("character varying")
                .HasColumnName("production_companies");
            entity.Property(e => e.ProductionCountries)
                .HasColumnType("character varying")
                .HasColumnName("production_countries");
            entity.Property(e => e.ReleaseDate)
                .HasColumnType("character varying")
                .HasColumnName("release_date");
            entity.Property(e => e.Revenue).HasColumnName("revenue");
            entity.Property(e => e.Runtime).HasColumnName("runtime");
            entity.Property(e => e.SpokenLanguages)
                .HasColumnType("character varying")
                .HasColumnName("spoken_languages");
            entity.Property(e => e.Status)
                .HasColumnType("character varying")
                .HasColumnName("status");
            entity.Property(e => e.Tagline)
                .HasColumnType("character varying")
                .HasColumnName("tagline");
            entity.Property(e => e.Title)
                .HasColumnType("character varying")
                .HasColumnName("title");
            entity.Property(e => e.Video).HasColumnName("video");
            entity.Property(e => e.VoteAverage).HasColumnName("vote_average");
            entity.Property(e => e.VoteCount).HasColumnName("vote_count");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

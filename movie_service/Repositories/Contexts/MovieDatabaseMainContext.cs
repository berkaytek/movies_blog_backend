using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

using movies_blog_backend.Models;
namespace movies_blog_backend.Repositories.Contexts;



public partial class MovieDatabaseMainContext : DbContext
{
    public MovieDatabaseMainContext()
    {
    }

    public MovieDatabaseMainContext(DbContextOptions<MovieDatabaseMainContext> options)
        : base(options)
    {
    }

    public virtual DbSet<Movie> Movies { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseNpgsql("Host=localhost; Database=movie_database_main; Username=root; Password=root");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Movie>(entity =>
        {
            entity
                .HasNoKey()
                .ToTable("movies");

            entity.Property(e => e.BackdropPath)
                .HasColumnType("character varying")
                .HasColumnName("backdrop_path");
            entity.Property(e => e.Budget).HasColumnName("budget");
            entity.Property(e => e.Credits)
                .HasColumnType("character varying")
                .HasColumnName("credits");
            entity.Property(e => e.Genres)
                .HasColumnType("character varying")
                .HasColumnName("genres");
            entity.Property(e => e.Id).HasColumnName("id");
            entity.Property(e => e.Keywords)
                .HasColumnType("character varying")
                .HasColumnName("keywords");
            entity.Property(e => e.OriginalLanguage)
                .HasColumnType("character varying")
                .HasColumnName("original_language");
            entity.Property(e => e.Overview)
                .HasColumnType("character varying")
                .HasColumnName("overview");
            entity.Property(e => e.Popularity).HasColumnName("popularity");
            entity.Property(e => e.PosterPath)
                .HasColumnType("character varying")
                .HasColumnName("poster_path");
            entity.Property(e => e.ProductionCompanies)
                .HasColumnType("character varying")
                .HasColumnName("production_companies");
            entity.Property(e => e.Recommendations)
                .HasColumnType("character varying")
                .HasColumnName("recommendations");
            entity.Property(e => e.ReleaseDate).HasColumnName("release_date");
            entity.Property(e => e.Revenue).HasColumnName("revenue");
            entity.Property(e => e.Runtime).HasColumnName("runtime");
            entity.Property(e => e.Status)
                .HasColumnType("character varying")
                .HasColumnName("status");
            entity.Property(e => e.Tagline)
                .HasColumnType("character varying")
                .HasColumnName("tagline");
            entity.Property(e => e.Title)
                .HasColumnType("character varying")
                .HasColumnName("title");
            entity.Property(e => e.VoteAverage).HasColumnName("vote_average");
            entity.Property(e => e.VoteCount).HasColumnName("vote_count");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}

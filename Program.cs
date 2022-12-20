using movies_blog_backend.Services.Interfaces;
using movies_blog_backend.Services;
using Microsoft.EntityFrameworkCore;

using movies_blog_backend.Repositories.Contexts;

var builder = WebApplication.CreateBuilder(args);

var config = new ConfigurationBuilder()
        .SetBasePath(Directory.GetCurrentDirectory())
        .AddJsonFile("appsettings.json", optional: true)
        .AddCommandLine(args)
        .Build(); ;

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle

builder.Services.AddDbContext<MoviesDatabaseContext>(options =>
    options.UseNpgsql(config.GetSection("ConnectionStrings:PostgreDatabase").Value)
);
//Cors

builder.Services.AddCors(p => p.AddPolicy("CorsConfig", builder =>
{
    builder.WithOrigins("*").AllowAnyMethod().AllowAnyHeader();
}));

// Dependency injections
builder.Services.AddScoped<IMoviesService, MoviesService>();

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();


// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.UseCors("CorsConfig");

app.MapControllers();

app.Run();

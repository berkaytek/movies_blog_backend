namespace movies_blog_backend.Tests;
using Moq;
using movies_blog_backend.Controllers;
using movies_blog_backend.Repositories.Contexts;
using Microsoft.EntityFrameworkCore;
using movies_blog_backend.Models;
using movies_blog_backend.Services;

[TestFixture]
public class MoviesControllerTests
{
    private MoviesController _mockMovieController;
    private  Mock<MoviesService> _mockMovieService;
    private Mock<MovieDatabaseMainContext> _mockContext;

    [SetUp]
    public void Setup()
    {
        // setup db context
        var mockContext = new Mock<MovieDatabaseMainContext>();
        var mockDbSet = new Mock<DbSet<Movie>>();
        _mockContext.Setup(c => c.Movies).Returns(mockDbSet.Object);
        // setup service
        _mockMovieService = new Mock<MoviesService>(_mockContext);
        

        _mockMovieController = new MoviesController(_mockMovieService.Object);
    }

    [Test]
    public async Task TestGetMovieData()
    {
        // Arrange the test
        var movieDatas = new List<MovieBase>();

        // act
         movieDatas = await _mockMovieController.GetMoviesByStartAndEndIndex(0,5);

        // assert

        Assert.IsNotNull(movieDatas);
        Assert.AreEqual(5,movieDatas.Count());

    }
}

/*
        // first movie
        var MovieMetaData1 = new MovieMetadataBase(  
        homepage: "http://toystory.disney.com/toy-story",
        id: "862",
        posterPath: "/rhIRbceoE9lR4veEXuwCC2wARtG.jpg",
        title: "Toy Story"
        );
*/
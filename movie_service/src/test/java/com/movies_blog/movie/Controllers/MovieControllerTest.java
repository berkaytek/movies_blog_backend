package com.movies_blog.movie.Controllers;

import com.movies_blog.common.Entities.Movie;
import com.movies_blog.movie.Models.MovieModelAssembler;
import com.movies_blog.movie.Repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MovieControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MovieRepository repository;

    @Mock
    private MovieModelAssembler movieAssembler;

    @InjectMocks
    private MovieController controller;

    private List<Movie> movies;

    /*@BeforeEach
    public void setUp() {
        movies = new ArrayList<>();
        movies.add(new Movie(
                442094,
                "Check Point",
                "Action",
                "en",
                "Port City North Carolina: During a routine camp out a local vagrant discovers plans for an invasion in America. When he tries to notify the local Sheriff about his discovery the Sheriff dismisses his claims and has him locked up for loitering. When the Sheriff notices odd interactions with other towns folk he begins to look into the vagrants' claim of a sleeper cell living amongst the locals within this small town. After evidence of a beheading is exposed others begin to fear that the insurgents attack on hometown USA. Questions and tempers begin to rise. Why this little beach community with it's Norman Rockwell way of life? A town where everyone knows one another... or so they thought. When the truth is blind and justice seems lost It will take an army of five unlikely heroes banding together to infiltrate the insurgents and foil their invasion plans.",
                5F,
                "Chasing Butterflies-Church Hill Productions-Apothecary Entertainment-Chasing Butterflies Pictures-Samera Entertainment",
                new Date(),
                2500000.0,
                0.0,
                97.0,
                "Released",
                "Run. Hide. Or Fight.",
                6.4,
                51.0,
                "William Forsythe-Kenny Johnson-Kane Hodder-Mindy Robinson-Tyler Mane-Bill Goldberg-Fred Williamson-Michelle Lee-Stephen Geoffreys-Ricky Harris-John Lewis-Krista Grotte Saxon-Mel Novak-Olga Safari-David Schifter-Robert Fortunato-Deaven Brooks-Michael Zovistoski-Adam J. Reeb-Marco DelVecchio-Tom Gore-Holly Anderson Storey",
                "post traumatic stress disorder-invasion-north carolina-vagrant-domestic terrorism-wounded warrior",
                "/wVeCqZYoAq8SK0CtDxERo2Ze9co.jpg",
                "/lFZSl4SW9MF5oP66Vh8dMXvCTUe.jpg",
                "550290-547016"
        ));
        movies.add(new Movie(
                1231231,
                "Avatar",
                "Epic",
                "en",
                "Blue man does funny stuff",
                5F,
                "Avatar production",
                new Date(),
                2500000.0,
                0.0,
                97.0,
                "Ended",
                "Blue man strong",
                9.4,
                5156.0,
                "Blue man, bob the dog",
                "New world",
                "/wVeCqZYoAq8SK0CtDxERo2Ze9co.jpg",
                "/lFZSl4SW9MF5oP66Vh8dMXvCTUe.jpg",
                "550290-547016"
        ));
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAll() throws Exception {
        when(repository.findAll()).thenReturn(movies);

        List<EntityModel<Movie>> movieModels = new ArrayList<>();
        for (Movie movie : movies) {
            movieModels.add(movieAssembler.toModel(movie));
        }


        CollectionModel<EntityModel<Movie>> expected = CollectionModel.of(movieModels,
                linkTo(methodOn(MovieController.class).getAll()).withSelfRel());

        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$._embedded.movies", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$._embedded.movies[0].id", is(442094)))
                .andExpect((ResultMatcher) jsonPath("$._embedded.movies[1].id", is(1231231)));

    }

    @Test
    void getOneMovie() {
    }*/
}
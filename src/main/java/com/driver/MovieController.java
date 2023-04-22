package com.driver;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService = new MovieService();

//   1. Add a movie: POST /movies/add-movie

    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
        String ans = movieService.addMovie(movie);
        return ans;
    }

//   2. Add a director: POST /movies/add-director

    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
        String ans = movieService.addDirector(director);
        return ans;
    }

//   3.  Pair an existing movie and director: PUT /movies/add-movie-director-pair

    @PostMapping("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("movieName")String movieName, @RequestParam("directorName")String directorName){
        String ans = movieService.addMovieDirectorPair(movieName, directorName);
        return ans;
    }

//   4.  Get Movie by movie name: GET /movies/get-movie-by-name/{name}

    @GetMapping("/get-movie-by-name/{name}")
    public Movie getMovieByName(@RequestParam("name")String name){
        Movie movie = movieService.getMovieByName(name);
        return movie;
    }

//   5.  Get Director by director name: GET /movies/get-director-by-name/{name}

    @GetMapping("/get-director-by-name/{name}")
    public Director getDirectorByName(@RequestParam("name")String name){
        Director director = movieService.getDirectorByName(name);
        return director;
    }

//   6.  Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}

    @GetMapping("/get-movies-by-director-name/{director}")
    public List<String> getMoviesByDirectorName(@RequestParam("name")String name){
        List<String> movies = movieService.getMoviesByDirectorName(name);
        return movies;
    }

//   7.  Get List of all movies added: GET /movies/get-all-movies

    @GetMapping("/get-all-movies")
    public List<String> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return movies;
    }

//   8.  Delete a director and its movies from the records: DELETE /movies/delete-director-by-name

    @DeleteMapping("/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("name")String name){
        String ans = movieService.deleteDirectorByName(name);
        return ans;
    }

//   9.  Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors

    @DeleteMapping("/delete-all-directors")
    public String deleteAllDirectors(){
        String ans = movieService.deleteAllDirectors();
        return ans;
    }
}

package com.project.cedrus.controllers;

import com.project.cedrus.exceptions.ResourceNotFoundException;
import com.project.cedrus.models.Movie;
import com.project.cedrus.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<Iterable<Movie>> getAllMovies(){
        Iterable<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok().body(movies);
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable (value="id") java.util.UUID id ){
        Movie movie = movieRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Requested movie id : "+id.toString()+ " was not found."));

        return ResponseEntity.ok().body(movie);
    }
    @CrossOrigin
    @PostMapping("")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        this.movieRepository.save(movie);
        return new ResponseEntity<String>("Created", HttpStatus.CREATED);
    }
}

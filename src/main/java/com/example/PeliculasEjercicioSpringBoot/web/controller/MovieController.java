package com.example.PeliculasEjercicioSpringBoot.web.controller;


import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

private final MovieService movieService;

public MovieController(MovieService movieService) {
    this.movieService = movieService;

}
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
       return ResponseEntity.ok(this.movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id){
        MovieDto movieDto = this.movieService.findById(id);
        if(movieDto == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody MovieDto movieDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.addMovie(movieDto));
    }
}

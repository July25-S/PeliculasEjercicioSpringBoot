package com.example.PeliculasEjercicioSpringBoot.web.controller;


import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.domain.dto.SuggestRequestDto;
import com.example.PeliculasEjercicioSpringBoot.domain.dto.UpdateMovieDto;
import com.example.PeliculasEjercicioSpringBoot.domain.service.MovieService;
import com.example.PeliculasEjercicioSpringBoot.domain.service.PeliculasAiService;
import dev.langchain4j.service.UserMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

private final MovieService movieService;
private final PeliculasAiService aiService;

public MovieController(MovieService movieService,
                       PeliculasAiService aiService) {
    this.movieService = movieService;
    this.aiService = aiService;


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


    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody UpdateMovieDto updateMovieDto){
       return ResponseEntity.ok(this.movieService.updateMovie(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/suggestion")
    public ResponseEntity<String> generateMovieSuggestion(@RequestBody SuggestRequestDto suggestRequestDto){
        return ResponseEntity.ok(this.aiService.generateMovieSuggestion(suggestRequestDto.userPreferences()));
    }
}

package com.example.PeliculasEjercicioSpringBoot.domain.service;

import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.domain.dto.UpdateMovieDto;
import com.example.PeliculasEjercicioSpringBoot.presistence.crud.CrudMovieRepository;
import com.example.PeliculasEjercicioSpringBoot.presistence.crud.MovieRepository;
import com.example.PeliculasEjercicioSpringBoot.presistence.mapper.MovieMapper;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Tool("Busca todas las películas disponibles en la base de datos.")
    public List<MovieDto> findAllMovies() {
        return this.movieRepository.findAll();

    }

    public MovieDto findById(long id) {
        return this.movieRepository.findById(id);
    }

    public MovieDto addMovie(MovieDto movieDto) {
        return this.movieRepository.addMovie(movieDto);
    }

    public MovieDto updateMovie(long id, UpdateMovieDto updateMovieDto) {
        return this.movieRepository.updateMovie(id, updateMovieDto);
    }

    public void delete(long id) {
        this.movieRepository.delete(id);
    }
}




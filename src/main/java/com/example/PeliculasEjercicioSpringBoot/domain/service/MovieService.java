package com.example.PeliculasEjercicioSpringBoot.domain.service;

import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.presistence.crud.CrudMovieRepository;
import com.example.PeliculasEjercicioSpringBoot.presistence.crud.MovieRepository;
import com.example.PeliculasEjercicioSpringBoot.presistence.mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<MovieDto> findAllMovies() {
        return this.movieRepository.findAll();

    }

    public MovieDto findById(long id) {
        return this.movieRepository.findById(id);
    }

    public MovieDto addMovie(MovieDto movieDto) {
        return this.movieRepository.addMovie(movieDto);
    }
}



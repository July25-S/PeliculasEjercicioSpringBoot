package com.example.PeliculasEjercicioSpringBoot.presistence.crud;


import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository{
    List<MovieDto> findAll();
    MovieDto findById(long id);
    MovieDto addMovie(MovieDto movieDto);
    MovieDto updateMovie(long id, UpdateMovieDto updateMovieDto);
    void delete(long id);
}

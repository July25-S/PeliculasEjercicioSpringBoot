package com.example.PeliculasEjercicioSpringBoot.presistence.crud;


import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;

import java.util.List;

public interface MovieRepository{
    List<MovieDto> findAll();
    MovieDto findById(long id);
    MovieDto addMovie(MovieDto movieDto);

}

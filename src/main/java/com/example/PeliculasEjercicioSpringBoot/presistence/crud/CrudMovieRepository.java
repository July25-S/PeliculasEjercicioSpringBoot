package com.example.PeliculasEjercicioSpringBoot.presistence.crud;

import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.presistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieRepository extends CrudRepository<MovieEntity, Long> {
}

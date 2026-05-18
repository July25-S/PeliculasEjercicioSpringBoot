package com.example.PeliculasEjercicioSpringBoot.presistence.crud;

import com.example.PeliculasEjercicioSpringBoot.presistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieRepository extends CrudRepository<MovieEntity, Long> {
    // Ajustado para coincidir con el nombre del campo en MovieEntity ("titulo")
    MovieEntity findByTitulo(String titulo);
}

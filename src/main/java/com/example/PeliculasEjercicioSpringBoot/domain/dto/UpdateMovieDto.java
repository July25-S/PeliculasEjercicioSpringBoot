package com.example.PeliculasEjercicioSpringBoot.domain.dto;

import com.example.PeliculasEjercicioSpringBoot.domain.Genere;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateMovieDto(
                             String titulo,
                             Genere genero,
                             LocalDate fechaEstreno) {
}

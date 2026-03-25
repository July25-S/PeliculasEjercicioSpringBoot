package com.example.PeliculasEjercicioSpringBoot.domain.dto;

import com.example.PeliculasEjercicioSpringBoot.domain.Genere;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MovieDto(
        Long id,
        String titulo,
        Genere genero,
        int duracion,
        LocalDate fecha_estreno,
        BigDecimal clasificacion
) {
}

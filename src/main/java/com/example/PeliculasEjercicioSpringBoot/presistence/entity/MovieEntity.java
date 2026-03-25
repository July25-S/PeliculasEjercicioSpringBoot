package com.example.PeliculasEjercicioSpringBoot.presistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150, unique = true)
    private String titulo;

    @Column(nullable = false, precision = 3)
    private Integer duracion;

    @Column(nullable = false, length = 40)
    private String genero;

    @Column(nullable = false)
    private LocalDate fecha_estreno;

    @Column(precision = 3, scale = 2)
    private BigDecimal clasificacion;

    @Column(nullable = false, length = 1)
    private String estado;
}

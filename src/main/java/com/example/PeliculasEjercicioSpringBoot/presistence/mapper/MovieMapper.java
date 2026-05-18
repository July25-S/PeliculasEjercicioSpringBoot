package com.example.PeliculasEjercicioSpringBoot.presistence.mapper;


import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.domain.dto.UpdateMovieDto;
import com.example.PeliculasEjercicioSpringBoot.presistence.entity.MovieEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenereMapper.class})
public interface MovieMapper {

    @Mapping(target = "genero", source = "genero", qualifiedByName = "stringToGenere")
    MovieDto toDto(MovieEntity movieEntity);

    @Named("toListDto")
    List<MovieDto> toListDto(Iterable<MovieEntity> entities);

    @InheritInverseConfiguration
    @Mapping(target = "genero", source = "genero", qualifiedByName = "genereToString")
    MovieEntity toEntity(MovieDto dto);


    void updateEntityFromDto(UpdateMovieDto dto, @MappingTarget MovieEntity entity);


}

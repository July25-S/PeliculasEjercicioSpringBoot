package com.example.PeliculasEjercicioSpringBoot.presistence;


import com.example.PeliculasEjercicioSpringBoot.domain.dto.MovieDto;
import com.example.PeliculasEjercicioSpringBoot.domain.dto.UpdateMovieDto;
import com.example.PeliculasEjercicioSpringBoot.presistence.crud.CrudMovieRepository;
import com.example.PeliculasEjercicioSpringBoot.presistence.crud.MovieRepository;
import com.example.PeliculasEjercicioSpringBoot.presistence.entity.MovieEntity;
import com.example.PeliculasEjercicioSpringBoot.presistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieRepository crudMovieRepository;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieRepository crudMovieRepository,
                                 MovieMapper movieMapper) {
        this.crudMovieRepository = crudMovieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> findAll(){
        return this.movieMapper.toListDto(this.crudMovieRepository.findAll());
    }

    @Override
    public MovieDto findById(long id){
        MovieEntity movieEntity = this.crudMovieRepository.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto){
        // Usar el nombre del método que corresponde al campo 'titulo' de la entidad
        if (this.crudMovieRepository.findByTitulo(movieDto.titulo())!=null) {
            // O lanzar una excepción personalizada
        }
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setEstado("D");
        MovieEntity savedMovieEntity = this.crudMovieRepository.save(movieEntity);
        return this.movieMapper.toDto(savedMovieEntity);
    }

    @Override
    public MovieDto updateMovie(long id, UpdateMovieDto updateMovieDto){
        MovieEntity movieEntity = this.crudMovieRepository.findById(id).orElse(null);
        if(movieEntity == null)return null;

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieRepository.save(movieEntity));

    }

    @Override
    public void delete(long id){
        this.crudMovieRepository.deleteById(id);
    }

}

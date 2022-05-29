package com.infraestructura.autores.repository;

import java.util.Optional;

import com.infraestructura.autores.model.Autor;

import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
    public Autor findByArtistName(String artistName);
    Optional<Autor> findByName(String titulo);
    void deleteById(Long id);
}

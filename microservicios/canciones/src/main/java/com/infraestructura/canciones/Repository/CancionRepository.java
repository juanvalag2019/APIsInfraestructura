package com.infraestructura.canciones.Repository;

import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends CrudRepository<Cancion, Long>{
    Optional<Cancion> findById(Long id);
    void deleteById(Long id);
    Optional<Cancion> findByTitulo(String titulo);
    void deleteByAutor(Long autor);
}

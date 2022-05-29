package com.infraestructura.canciones.Repository;

import java.util.List;
import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Long> {
    Optional<Cancion> findById(Long id);

    void deleteById(Long id);

    Optional<Cancion> findByTitulo(String titulo);

    List<Cancion> deleteByAutor(long autor);
}

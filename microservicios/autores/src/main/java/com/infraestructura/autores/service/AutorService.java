package com.infraestructura.autores.service;

import java.util.Optional;

import com.infraestructura.autores.model.Autor;

public interface AutorService {
    public Autor createAutor(Autor autor);

    public Optional<Autor> findById(Long id);
}

package com.infraestructura.autores.service;

import java.util.List;
import java.util.Optional;

import com.infraestructura.autores.model.Autor;

public interface AutorService {
    public Autor createAutor(Autor autor);

    public Optional<Autor> findById(Long id);

    public List<Autor> getAllAutors();

    public String deleteAutor(Long idAutor);

    public Autor updateAutor(Long id, Autor Autor);

    public Autor getAutorByName(String nomAutor);
}

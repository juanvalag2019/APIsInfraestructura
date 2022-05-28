package com.infraestructura.autores.service;

import java.util.Optional;

import com.infraestructura.autores.model.Autor;
import com.infraestructura.autores.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepo;

    public Autor createAutor(Autor autor) {
        return autorRepo.save(autor);
    }

    public Optional<Autor> findById(Long id) {
        return autorRepo.findById(id);
    }
}

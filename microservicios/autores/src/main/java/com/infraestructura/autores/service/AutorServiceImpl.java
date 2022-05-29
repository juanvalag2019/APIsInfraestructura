package com.infraestructura.autores.service;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<Autor> getAllAutors() {
        Iterable<Autor> iterAutors = autorRepo.findAll();
        List<Autor> autores = new ArrayList<>();    
        iterAutors.forEach(autores::add);    
        return autores;
    }

    @Override
    public String deleteAutor(Long idAutor) {
        autorRepo.deleteById(idAutor);
        return "Elimino el autor" + idAutor;
    }

    @Override
    public Autor updateAutor(String nomAutor, Autor autor) {
        Autor old = getAutorByName(nomAutor);
        autor.setId(old.getId());
        return autorRepo.save(autor);
    }

    @Override
    public Autor getAutorByName(String nomAutor) {
        Optional<Autor> posibleSong = autorRepo.findByName(nomAutor);
        return posibleSong.get();
    }
}

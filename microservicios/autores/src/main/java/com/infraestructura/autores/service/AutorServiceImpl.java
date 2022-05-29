package com.infraestructura.autores.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.infraestructura.autores.model.Autor;
import com.infraestructura.autores.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepo;
    @Autowired
    private RestTemplate restTemplate;

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
        System.out.println("Tratando de eliminar");
        String url = "http://localhost:8082/api/songs/autor/" + idAutor;
        restTemplate.delete(url);
        System.out.println("Eliminandas canciones");
        autorRepo.deleteById(idAutor);
        return "Elimino el autor" + idAutor;
    }

    @Override
    public Autor updateAutor(Long id, Autor autor) {
        Optional<Autor> possibleOld = findById(id);
        System.out.println(possibleOld);
        if (possibleOld.isPresent()) {
            Autor old = possibleOld.get();
            autor.setId(old.getId());
        }
        return autorRepo.save(autor);
    }

    @Override
    public Autor getAutorByName(String nomAutor) {
        Optional<Autor> posibleSong = autorRepo.findByName(nomAutor);
        return posibleSong.get();
    }
}

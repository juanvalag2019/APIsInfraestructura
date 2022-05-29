package com.infraestructura.autores.controller;

import java.util.List;
import java.util.Optional;

import com.infraestructura.autores.model.Autor;
import com.infraestructura.autores.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autors")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Autor> getAutor(@PathVariable Long id) {
        Optional<Autor> posibleAutor = autorService.findById(id);
        if (posibleAutor.isPresent()) {
            return new ResponseEntity<>(posibleAutor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
        try {
            Autor newAutor = autorService.createAutor(autor);
            return new ResponseEntity<>(newAutor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity getAllAutors() {
        List<Autor> posiblesAutores = autorService.getAllAutors();
        return new ResponseEntity<>(posiblesAutores, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteAutors(@PathVariable("id") Long idAutor) {
        try {
            String deleteAutors = autorService.deleteAutor(idAutor);
            return new ResponseEntity<>(deleteAutors, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity updateAutors(@RequestBody Autor autor,
            @PathVariable Long id) {
        try {
            Autor updated = autorService.updateAutor(id, autor);
            return new ResponseEntity<Autor>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}

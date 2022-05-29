package com.infraestructura.canciones.Controller;

import java.util.List;
import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;
import com.infraestructura.canciones.Service.CancionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/songs")
public class CancionController {
    @Autowired
    private CancionService cancionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cancion> getSong(@PathVariable("id") Long idCancion) {
        Optional<Cancion> posibleCancion = cancionService.getSong(idCancion);
        if (posibleCancion.isPresent()) {
            return new ResponseEntity<>(posibleCancion.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List> getAllSongs() {
        List<Cancion> posiblesCanciones = cancionService.getAllSongs();
        return new ResponseEntity<>(posiblesCanciones, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Cancion> createSong(@RequestBody Cancion cancion) {
        Cancion newSong = cancionService.createSong(cancion);
        if (newSong != null) {
            return new ResponseEntity<>(newSong, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable("id") Long idCancion) {
        try {
            String deleteSong = cancionService.deleteSong(idCancion);
            return new ResponseEntity<>(deleteSong, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Cancion> updateSong(@RequestBody Cancion song,
            @PathVariable("id") Long id) {
        Cancion updated = cancionService.updateSong(id, song);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/autor/{autor}")
    public ResponseEntity<String> deleteSongs(@PathVariable("autor") Long autor) {
        try {
            System.out.println("Id autor: " + autor);
            String deleteSong = cancionService.deleteSongs(autor);
            return new ResponseEntity<>(deleteSong, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

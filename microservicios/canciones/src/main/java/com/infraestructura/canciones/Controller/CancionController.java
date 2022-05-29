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
        if (!posiblesCanciones.isEmpty()) {
            return new ResponseEntity<>(posiblesCanciones, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<Cancion> createSong(@RequestBody Cancion cancion) {
        try {
            Cancion newSong = cancionService.createSong(cancion);
            return new ResponseEntity<>(newSong, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable("id") Long idCancion) {
        try {
            String deleteSong = cancionService.deleteSong(idCancion);
            return new ResponseEntity<>(deleteSong, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{songName}")
    Cancion updateSong(@RequestBody Cancion song,
            @PathVariable("songName") String nomSong) {
        return cancionService.updateSong(nomSong, song);
    }
}

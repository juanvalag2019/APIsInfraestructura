package com.infraestructura.canciones.Controller;

import java.lang.StackWalker.Option;
import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;
import com.infraestructura.canciones.Service.CancionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api/songs")
public class CancionController {
    @Autowired
    private CancionService cancionService; 

    @GetMapping(value= "/{id}")
    public ResponseEntity<Cancion> getSong (@PathVariable("id") Long idCancion) {
        Optional<Cancion> posibleCancion = cancionService.getSong(idCancion);
        if(posibleCancion.isPresent()){
            return new ResponseEntity<>(posibleCancion.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/")    
    public ResponseEntity<Cancion> createSong (@RequestBody Cancion cancion) {
        try{            
            Cancion newSong = cancionService.createSong(cancion);
            return new ResponseEntity<>(newSong, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.infraestructura.canciones.Controller;

import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;
import com.infraestructura.canciones.Service.CancionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/canciones")
public class CancionController {
    @Autowired
    private CancionService cancionService; 

    @GetMapping("/{getSong}")
    Optional<Cancion> getSong (@PathVariable String idCancion) {
        return cancionService.getSong(idCancion);
    }

    @PostMapping("/{createSong}")
    Cancion createSong (@PathVariable Cancion cancion) {
        cancionService.createSong(cancion);
        return cancion;
    }
}

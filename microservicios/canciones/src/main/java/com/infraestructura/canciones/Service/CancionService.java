package com.infraestructura.canciones.Service;

import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;

public interface CancionService {
    
    public Cancion createSong(Cancion cancion);

    public Optional<Cancion> getSong(Long idCancion);
}

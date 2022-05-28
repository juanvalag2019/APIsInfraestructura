package com.infraestructura.canciones.Service;

import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;

public interface CancionService {
    
    public void createSong(Cancion cancion);

    public Optional<Cancion> getSong(String idCancion);
}

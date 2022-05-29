package com.infraestructura.canciones.Service;

import java.util.List;
import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;


public interface CancionService {
    
    public Cancion createSong(Cancion cancion);

    public Optional<Cancion> getSong(Long idCancion);

    public List<Cancion> getAllSongs();

    public String deleteSong(Long idCancion);

    public String deleteSongs(Long idAutor);

    public Cancion updateSong(String nomSong, Cancion song);

    public Cancion getSongByName(String nomSong);
}

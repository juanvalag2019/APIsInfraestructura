package com.infraestructura.canciones.Service;

import java.util.List;
import java.util.Optional;

import com.infraestructura.canciones.Model.Autor;
import com.infraestructura.canciones.Model.Cancion;

public interface CancionService {

    public Cancion createSong(Cancion cancion);

    public Optional<Cancion> getSong(Long idCancion);

    public List<Cancion> getAllSongs();

    public String deleteSong(Long idCancion);

    public Cancion updateSong(Long id, Cancion song);

    public Cancion getSongByName(String nomSong);

    public Autor getAutorById(Long id);
}

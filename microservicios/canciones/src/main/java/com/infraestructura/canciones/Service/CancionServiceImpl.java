package com.infraestructura.canciones.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.infraestructura.canciones.Model.Autor;
import com.infraestructura.canciones.Model.Cancion;
import com.infraestructura.canciones.Repository.CancionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CancionServiceImpl implements CancionService {
    @Autowired
    CancionRepository cancionRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Cancion createSong(Cancion cancion) {
        Autor autor = getAutorById(cancion.getIdAutor());
        if (autor != null) {
            return cancionRepository.save(cancion);
        } else {
            return null;
        }
    }

    @Override
    public Optional<Cancion> getSong(Long idCancion) {
        return cancionRepository.findById(idCancion);
    }

    @Override
    public List<Cancion> getAllSongs() {
        Iterable<Cancion> iterActividades = cancionRepository.findAll();
        List<Cancion> canciones = new ArrayList<>();
        iterActividades.forEach(canciones::add);
        return canciones;
    }

    @Override
    public String deleteSong(Long idCancion) {
        cancionRepository.deleteById(idCancion);
        return "Elimino la cancion" + idCancion;
    }

    @Override
    public Cancion getSongByName(String nomSong) {
        Optional<Cancion> posibleSong = cancionRepository.findByTitulo(nomSong);
        return posibleSong.get();
    }

    @Override
    public Cancion updateSong(Long id, Cancion song) {
        Optional<Cancion> possibleOld = getSong(id);
        if (possibleOld.isPresent()) {
            Cancion old = possibleOld.get();
            song.setId(old.getId());
            Autor autor = getAutorById(song.getIdAutor());
            if (autor != null) {
                return cancionRepository.save(song);
            }
        }
        return null;
    }

    @Override
    public Autor getAutorById(Long id) {
        String url = "http://localhost:8080/api/autors/" + id;
        try {
            return restTemplate.getForObject(url, Autor.class);
        } catch (Exception e) {
            return null;
        }
    }

}

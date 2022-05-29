package com.infraestructura.canciones.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.infraestructura.canciones.Model.Autor;
import com.infraestructura.canciones.Model.Cancion;
import com.infraestructura.canciones.Repository.CancionRepository;

import org.hibernate.loader.ColumnEntityAliases;
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
        String url = "http://localhost:8081/api/autors/" + cancion.getAutor();
        Autor autor = (Autor) restTemplate.getForObject(url, Autor.class);
        if(autor != null){
            return cancionRepository.save(cancion);    
        }else{
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
    public Cancion getSongByName(String nomSong){
        Optional<Cancion> posibleSong = cancionRepository.findByTitulo(nomSong);
        return posibleSong.get();
    }

    @Override
    public Cancion updateSong(String nomSong, Cancion song) {
        Cancion old = getSongByName(nomSong);
        song.setId(old.getId());
        return cancionRepository.save(song);        
    }

    @Override
    public String deleteSongs(Long idAutor) {
        cancionRepository.deleteByAutor(idAutor);
        return "Elimino la cancion" + idAutor;
    }

    
}

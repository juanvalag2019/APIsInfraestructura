package com.infraestructura.canciones.Service;

import java.util.Optional;

import com.infraestructura.canciones.Model.Cancion;
import com.infraestructura.canciones.Repository.CancionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancionServiceImpl implements CancionService {
    @Autowired
    CancionRepository cancionRepository;

    @Override
    public void createSong(Cancion cancion) {
        cancionRepository.save(cancion);        
    }

    @Override
    public Optional<Cancion> getSong(String idCancion) {        
        return cancionRepository.findById(idCancion);
    }
    
}

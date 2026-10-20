package com.estebancardozo.tiendadiscos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estebancardozo.tiendadiscos.entity.Album;
import com.estebancardozo.tiendadiscos.entity.Edicion;
import com.estebancardozo.tiendadiscos.exception.InvalidReferenceException;
import com.estebancardozo.tiendadiscos.exception.NotFoundException;
import com.estebancardozo.tiendadiscos.repository.AlbumRepository;
import com.estebancardozo.tiendadiscos.repository.EdicionRepository;

@Service
public class EdicionService {

    private final EdicionRepository edicionRepo;
    private final AlbumRepository albumRepo;

    public EdicionService(EdicionRepository edicionRepository, AlbumRepository albumRepo) {
        this.edicionRepo = edicionRepository;
        this.albumRepo = albumRepo;
    }

    public List<Edicion> findAll() {

        return edicionRepo.findAll();
    }

    public Edicion findById(Long id) {

        return edicionRepo.findById(id).orElseThrow(() -> new NotFoundException("Edicion", id));
    }

    public Edicion save(Edicion edicion, Long albumId) {

        edicion.setAlbum(
                albumRepo.findById(albumId).orElseThrow(() -> new InvalidReferenceException("Album", albumId)));

        edicion.setReservado(0);

        return edicionRepo.save(edicion);
    }

    public void delete(Long id) {
        if (!edicionRepo.existsById(id)) {
            throw new NotFoundException("Edicion", id);
        }
        edicionRepo.deleteById(id);
    }

    public Edicion update(Long id, Edicion edicion, Long albumId) {

        edicionRepo.findById(id).orElseThrow(() -> new NotFoundException("Edicion", id));

        edicion.setId(id);

        Album album = albumRepo.findById(albumId).orElseThrow(() -> new InvalidReferenceException("Album", albumId));

        edicion.setAlbum(album);
        return edicionRepo.save(edicion);

    }

}

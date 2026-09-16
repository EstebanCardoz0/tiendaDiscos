package com.estebancardozo.tiendadiscos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estebancardozo.tiendadiscos.entity.Album;
import com.estebancardozo.tiendadiscos.entity.Artista;
import com.estebancardozo.tiendadiscos.exception.InvalidReferenceException;
import com.estebancardozo.tiendadiscos.exception.NotFoundException;
import com.estebancardozo.tiendadiscos.repository.AlbumRepository;
import com.estebancardozo.tiendadiscos.repository.ArtistaRepository;

@Service
public class AlbumService {

    private final AlbumRepository albumRepo;
    private final ArtistaRepository artistaRepo;

    public AlbumService(AlbumRepository albumRepository, ArtistaRepository artistaRepository) {
        this.albumRepo = albumRepository;
        this.artistaRepo = artistaRepository;
    }

    public List<Album> findAll() {
        return albumRepo.findAll();

    }

    public Album findById(Long id) {
        return albumRepo.findById(id).orElseThrow(() -> new NotFoundException("Album", id));
    }

    public Album save(Album album, Long idArtista) {

        Artista artista = artistaRepo.findById(idArtista)
                .orElseThrow(() -> new InvalidReferenceException("Artista", idArtista));

        album.setArtista(artista);
        return albumRepo.save(album);

    }

    public Album update(Long id, Album album, Long idArtista) {

        if (!albumRepo.existsById(id)) {
            throw new NotFoundException("Album", id);
        }
        album.setId(id);

        Artista artista = artistaRepo.findById(idArtista)
                .orElseThrow(() -> new InvalidReferenceException("Artista", idArtista));

        album.setArtista(artista);

        return albumRepo.save(album);

    }

    public void delete(Long id) {
        if (!albumRepo.existsById(id)) {
            throw new NotFoundException("Album", id);
        }

        albumRepo.deleteById(id);

    }

}

package com.dbp.backendspotify.service;

import com.dbp.backendspotify.model.Artist;
import com.dbp.backendspotify.repository.ArtistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    // Método para buscar artistas por nombre
    public List<Artist> searchArtistsByName(String nombre) {
        return artistRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Método para obtener un artista por su ID
    public Optional<Artist> getArtistById(String username) {
        return artistRepository.findById(username);
    }
    public Page<Artist> getArtistsPaginated(int page, int size) {
        return artistRepository.findAll(PageRequest.of(page, size));
    }
}

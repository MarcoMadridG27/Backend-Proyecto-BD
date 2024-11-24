package com.dbp.backendspotify.service;

import com.dbp.backendspotify.dto.AlbumDTO;
import com.dbp.backendspotify.model.Album;
import com.dbp.backendspotify.repository.AlbumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    /**
     * Busca álbumes por nombre ignorando mayúsculas y minúsculas.
     */
    public List<AlbumDTO> searchAlbumsByName(String nombre) {
        return albumRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    /**
     * Obtiene una página de álbumes.
     */
    public Page<AlbumDTO> getAlbumsPaginated(int page, int size) {
        return albumRepository.findAll(PageRequest.of(page, size))
                .map(this::convertToDTO);
    }

    /**
     * Obtiene un álbum por ID.
     */
    public Optional<AlbumDTO> getAlbumById(String id) {
        return albumRepository.findById(id).map(this::convertToDTO);
    }

    /**
     * Convierte una entidad Album a un DTO AlbumDTO.
     */
    private AlbumDTO convertToDTO(Album album) {
        return new AlbumDTO(
                album.getIdAlbum(),
                album.getArtista() != null ? album.getArtista().getUsername() : null,
                album.getNombre(),
                album.getDuracion(),
                album.getTipo(),
                album.getGenero(),
                album.getArtista() != null ? album.getArtista().getNombre() : null
        );
    }

}

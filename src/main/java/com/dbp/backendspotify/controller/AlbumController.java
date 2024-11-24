package com.dbp.backendspotify.controller;

import com.dbp.backendspotify.dto.AlbumDTO;
import com.dbp.backendspotify.service.AlbumService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public ResponseEntity<Page<AlbumDTO>> getPaginatedAlbums(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<AlbumDTO> albums = albumService.getAlbumsPaginated(page, size)
                .map(album -> new AlbumDTO(
                        album.getIdAlbum(),
                        album.getUsername(),
                        album.getNombre(),
                        album.getDuracion(),
                        album.getTipo(),
                        album.getGenero(),
                        album.getArtista() != null ? album.getArtista() : null // Usar username del artista
                ));
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/search")
    public ResponseEntity<List<AlbumDTO>> searchAlbums(@RequestParam("nombre") String nombre) {
        List<AlbumDTO> albums = albumService.searchAlbumsByName(nombre)
                .stream()
                .map(album -> new AlbumDTO(
                        album.getIdAlbum(),
                        album.getUsername(),
                        album.getNombre(),
                        album.getDuracion(),
                        album.getTipo(),
                        album.getGenero(),
                        album.getArtista() != null ? album.getArtista() : null // Usar username del artista
                ))
                .toList(); // Java 16+ usa toList(); para versiones anteriores usa Collectors.toList()
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumDTO> getAlbumById(@PathVariable String id) {
        return albumService.getAlbumById(id)
                .map(album -> new AlbumDTO(
                        album.getIdAlbum(),
                        album.getUsername(),
                        album.getNombre(),
                        album.getDuracion(),
                        album.getTipo(),
                        album.getGenero(),
                        album.getArtista() != null ? album.getArtista() : null // Usar username del artista
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}

package com.dbp.backendspotify.controller;

import com.dbp.backendspotify.model.Artist;
import com.dbp.backendspotify.service.ArtistService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }


    @GetMapping
    public ResponseEntity<Page<Artist>> getPaginatedArtists(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(artistService.getArtistsPaginated(page, size));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Artist>> searchArtists(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(artistService.searchArtistsByName(nombre));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable String id) {
        return artistService.getArtistById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

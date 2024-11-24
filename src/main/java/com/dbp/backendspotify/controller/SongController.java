package com.dbp.backendspotify.controller;

import com.dbp.backendspotify.model.Artist;
import com.dbp.backendspotify.model.Song;
import com.dbp.backendspotify.service.SongService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @GetMapping("/search")
    public ResponseEntity<List<Song>> searchSongs(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(songService.searchSongsByName(nombre));
    }

    @GetMapping
    public ResponseEntity<Page<Song>> getPaginatedSongs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(songService.getSongsPaginated(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable String id) {
        return songService.getSongById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

package com.dbp.backendspotify.service;

import com.dbp.backendspotify.model.Song;
import com.dbp.backendspotify.repository.SongRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Optional<Song> getSongById(String id) {
        return songRepository.findById(id);
    }
    public List<Song> searchSongsByName(String nombre) {
        return songRepository.findByNombreContainingIgnoreCase(nombre);
    }
    public Page<Song> getSongsPaginated(int page, int size) {
        return songRepository.findAll(PageRequest.of(page, size));
    }
}

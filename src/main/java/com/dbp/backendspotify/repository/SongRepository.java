package com.dbp.backendspotify.repository;

import com.dbp.backendspotify.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
    @Query("SELECT s FROM Song s WHERE LOWER(s.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Song> findByNombreContainingIgnoreCase(@Param("nombre") String nombre);

    Page<Song> findAll(Pageable pageable);
}



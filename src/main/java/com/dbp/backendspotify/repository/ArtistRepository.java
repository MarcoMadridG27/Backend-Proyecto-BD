package com.dbp.backendspotify.repository;

import com.dbp.backendspotify.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
    @Query("SELECT a FROM Artist a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Artist> findByNombreContainingIgnoreCase(@Param("nombre") String nombre);

    Page<Artist> findAll(Pageable pageable);
}


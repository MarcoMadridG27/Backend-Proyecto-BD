package com.dbp.backendspotify.repository;

import com.dbp.backendspotify.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {
    @Query("SELECT a FROM Album a WHERE LOWER(a.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Album> findByNombreContainingIgnoreCase(@Param("nombre") String nombre);
    Page<Album> findAll(Pageable pageable);
}

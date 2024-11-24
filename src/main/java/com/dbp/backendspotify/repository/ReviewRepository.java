package com.dbp.backendspotify.repository;

import com.dbp.backendspotify.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
    // Métodos personalizados
    // Ejemplo: List<Review> findByPuntuacionGreaterThan(int puntuacion);
}

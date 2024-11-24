package com.dbp.backendspotify.repository;

import com.dbp.backendspotify.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    // Métodos personalizados
    // Ejemplo: List<Category> findByDanceabilidadGreaterThan(int valor);
}

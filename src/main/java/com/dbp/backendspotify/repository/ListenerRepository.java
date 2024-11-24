package com.dbp.backendspotify.repository;

import com.dbp.backendspotify.model.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListenerRepository extends JpaRepository<Listener, String> {
    // Métodos personalizados
    // Ejemplo: List<Listener> findByTipoSuscripcion(String tipoSuscripcion);
}

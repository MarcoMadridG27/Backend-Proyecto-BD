package com.dbp.backendspotify.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    @Id
    private String username; // ID del artista

    private String nombre; // Nombre del artista
    private int seguidores;
    private boolean verificado;
    private String selloDiscografico;
}



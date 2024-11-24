package com.dbp.backendspotify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    private String idAlbum;
    @Column(name = "username", insertable = false, updatable = false)
    private String username; // Columna compartida con la relación ManyToOne

    private String nombre;
    private int duracion;
    private String tipo;
    private String genero;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Artist artista; // Relación con Artist

    public Album(String idAlbum, String username, String nombre, int duracion, String tipo, String genero) {
    }

    // Getters y setters
}



package com.dbp.backendspotify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String idCategoria;

    private int danceabilidad;
    private int energia;
    private int tonalidad;
    private int volumen;
    private int volumenDePalabras;
    private int instrumentalidad;
    private int porcentajeGrabadoEnVivo;
    private int tempo; // BPM (beats por minuto)
    private int acusticidad;

    @ManyToOne
    private Song cancion; // Relación con Canción
}

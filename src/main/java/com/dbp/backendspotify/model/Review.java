package com.dbp.backendspotify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private String idResenia;

    private String contenido;
    private int puntuacion; // Rango de 0 a 10
    private LocalDate fecha;

    @ManyToOne
    private Album album; // Relación con Álbum

    @ManyToOne
    private Listener listener; // Relación con Oyente
}

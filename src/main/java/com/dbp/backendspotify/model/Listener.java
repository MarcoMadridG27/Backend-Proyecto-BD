package com.dbp.backendspotify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listener {
    @Id
    private String username;

    private String tipoSuscripcion; // Ejemplo: "premium" o "normal"
}

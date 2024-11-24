package com.dbp.backendspotify.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "cancion") // Nombre de la tabla en la base de datos
public class Song {

    @Id
    @Column(name = "id_cancion") // Mapear columna
    private String idCancion;

    @Column(name = "username") // Nombre del artista o creador
    private String username;

    @Column(name = "id_album")
    private String idAlbum;

    @Column(name = "nombre")
    private String nombre; // Nombre de la canción

    @Column(name = "popularidad")
    private int popularidad;

    @Column(name = "explicitud")
    private boolean explicit;

    @Column(name = "genero")
    private boolean genero;

    @Column(name = "duracion")
    private int duracion;

}

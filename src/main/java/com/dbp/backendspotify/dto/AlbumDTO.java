package com.dbp.backendspotify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// Genera un constructor con todos los argumentos
public class AlbumDTO {
    private String idAlbum;
    private String username; // ID del artista
    private String nombre;
    private int duracion;
    private String tipo;
    private String genero;
    private String artista; // Nombre del artista

    // Constructor específico para omitir 'artista' si no es necesario
    public AlbumDTO(String idAlbum, String username, String nombre, int duracion, String tipo, String genero) {
        this.idAlbum = idAlbum;
        this.username = username;
        this.nombre = nombre;
        this.duracion = duracion;
        this.tipo = tipo;
        this.genero = genero;
    }

    // Constructor con 's' renombrado para claridad
    public AlbumDTO(String idAlbum, String username, String nombre, int duracion, String tipo, String genero, String artista) {
        this.idAlbum = idAlbum;
        this.username = username;
        this.nombre = nombre;
        this.duracion = duracion;
        this.tipo = tipo;
        this.genero = genero;
        this.artista = artista;
    }
}

package org.example.models;

import lombok.Data;


/**
 * Clase que representa una pelicula con los atributos de la BD
 * **/
@Data
public class Pelicula {
    private Integer id;
    private String titulo;
    private Integer anio;
    private String genero;

    public Pelicula(String titulo, Integer anio, String genero) {
        this.titulo = titulo;
        this.anio = anio;
        this.genero = genero;
    }
    public Pelicula(){}

}

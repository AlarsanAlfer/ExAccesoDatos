package org.example;

import org.example.dao.PeliculaDAO;
import org.example.models.Pelicula;

/**
 * Clase main que nos ejecuta los diferentes metodos que se piden.
 * **/
public class Main {
    public static void main(String[] args) {
        PeliculaDAO peliculaDAO = new PeliculaDAO();

        peliculaDAO.filtrarAnio(2005,2015);

        System.out.println("---------------------------------------");

        System.out.println(peliculaDAO.contarP());

        System.out.println("-------------------------------------------");

        Pelicula p = new Pelicula("La peli de Ale", 1997, "Fantasía");
        peliculaDAO.save(p);
    }
}
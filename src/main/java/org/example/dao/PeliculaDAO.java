package org.example.dao;

import org.example.models.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements DAO<Pelicula>{

    /**
     * En este metodo obtenemos dos años, y a través de la consulta sql, filtramos las peliculas
     * que hay en la BD entre dichos años
     * **/

    public List<Pelicula> filtrarAnio(Integer anio1, Integer anio2) {
        List<Pelicula> resultado = new ArrayList<Pelicula>();
        try(Connection con = JdbcUtil.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from pelicula where año between ? and ?");
            ps.setInt(1, anio1);
            ps.setInt(2, anio2);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setAnio(rs.getInt("año"));
                p.setGenero(rs.getString("genero"));
                resultado.add(p);
            }
            resultado.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }


/**
 * Accedemos a la BD y a traves de la consulta sql, obtenemos el número total de peliculas
 * **/
    public Integer contarP(){
        Integer cuenta = 0;
        try(Connection con = JdbcUtil.getConnection()){
            PreparedStatement ps = con.prepareStatement("select COUNT(*) from pelicula");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                cuenta = rs.getInt("COUNT(*)");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cuenta;
    }
    // El método de guardar pelicula lo he hecho en el método predefinido más abajo: "save"



    @Override
    public List<Pelicula> findAll() {
        return List.of();
    }

    @Override
    public Pelicula findById(int id) {
        return null;
    }


    /**
     * Recibiendo una pelicula, con este método guardamos la pelicula en la BD
     * **/
    @Override
    public void save(Pelicula pelicula){
        try(Connection con = JdbcUtil.getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into pelicula (titulo, año, genero) values (?,?,?)");
            ps.setString(1, pelicula.getTitulo());
            ps.setInt(2, pelicula.getAnio());
            ps.setString(3, pelicula.getGenero());
            ps.executeUpdate();
            System.out.println("Guardado correctamente");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Pelicula pelicula) {

    }

    @Override
    public void update(Pelicula pelicula) {

    }
}

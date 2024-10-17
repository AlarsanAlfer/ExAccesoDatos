package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase Jdbc que nos hace la conexión con nuestra base de datos
 * **/
public class JdbcUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/BD";
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv("MYSQL_ROOT_PASSWORD");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

}
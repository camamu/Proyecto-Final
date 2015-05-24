/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peliculas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class PeliculasPrestadasOpImp implements PeliculasPrestadasOp {

    private Connection conexion;
    private PreparedStatement preparedStatement;

    public PeliculasPrestadasOpImp() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/peliculas_db", "carlos", "1qazZAQ!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void insertar(String pelicula, String usuario, String nombrePers) {
        try {
            preparedStatement = conexion.prepareStatement("INSERT INTO peliculasprestadas (pelicula, usuario, nombre) VALUES(?, ?, ?)");
            preparedStatement.setString(1, pelicula);
            preparedStatement.setString(2, usuario);
            preparedStatement.setString(3, nombrePers);
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasPrestadasOpImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<PeliculasPrestadas> consultar(String usuario) {
        List<PeliculasPrestadas> peliculas = new ArrayList<PeliculasPrestadas>();
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM peliculasprestadas WHERE usuario = ?");
            preparedStatement.setString(1, usuario);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PeliculasPrestadas pelicula = new PeliculasPrestadas();
                pelicula.setPelicula(resultSet.getString(1));
                pelicula.setUsuario(resultSet.getString(2));
                pelicula.setNombre(resultSet.getString(3));
                peliculas.add(pelicula);
            }
            return peliculas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<PeliculasPrestadas> consultarPelicula(String usuario, String titulo) {
        @SuppressWarnings("Convert2Diamond")
        List<PeliculasPrestadas> peliculas = new ArrayList<PeliculasPrestadas>();
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM peliculasprestadas WHERE usuario = ? AND pelicula LIKE ?");
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, "%"+titulo+"%");
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                PeliculasPrestadas pelicula = new PeliculasPrestadas();
                pelicula.setPelicula(resultSet.getString(1));
                pelicula.setUsuario(resultSet.getString(2));
                pelicula.setNombre(resultSet.getString(3));
                peliculas.add(pelicula);
            }
            return peliculas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void eliminar(String usuario, String titulo) {
        try {
            preparedStatement = conexion.prepareStatement("DELETE FROM peliculasprestadas WHERE pelicula = ? AND usuario = ?");
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, usuario);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasOpImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

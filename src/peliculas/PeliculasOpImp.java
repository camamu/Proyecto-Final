package peliculas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeliculasOpImp implements PeliculasOp {

    private Connection conexion;
    private PreparedStatement preparedStatement;

    public PeliculasOpImp() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/peliculas_db", "carlos", "1qazZAQ!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void insertar(String titulo, String director, String genero, int annoEstreno, FileInputStream caratula) {
        try {
            preparedStatement = conexion.prepareStatement("INSERT INTO peliculas VALUES( ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, director);
            preparedStatement.setString(3, genero);
            preparedStatement.setInt(4, annoEstreno);
            preparedStatement.setBlob(5, caratula);
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasOpImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertar(String titulo, String director, String genero, int annoEstreno) {
        try {
            preparedStatement = conexion.prepareStatement("INSERT INTO peliculas (titulo, director, genero, annoEstreno) VALUES( ?, ?, ?, ?)");
            preparedStatement.setString(1, titulo);
            preparedStatement.setString(2, director);
            preparedStatement.setString(3, genero);
            preparedStatement.setInt(4, annoEstreno);
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasOpImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pelicula> consultar() {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM peliculas");
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(resultSet.getString(1));
                pelicula.setDirector(resultSet.getString(2));
                pelicula.setGenero(resultSet.getString(3));
                pelicula.setAnnoEstreno(resultSet.getInt(4));
                pelicula.setCaratula(resultSet.getBlob(5));
                peliculas.add(pelicula);
            }
            return peliculas;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public List<Pelicula> buscarPelicula(String titulo) {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM peliculas  WHERE titulo LIKE ?");
            preparedStatement.setString(1, "%"+titulo+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(resultSet.getString(1));
                pelicula.setDirector(resultSet.getString(2));
                pelicula.setGenero(resultSet.getString(3));
                pelicula.setAnnoEstreno(resultSet.getInt(4));
                pelicula.setCaratula(resultSet.getBlob(5));
                peliculas.add(pelicula);
            }
            return peliculas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void modificar(String campo, String contenidoFinal, String contenidoOrigen) {
        try {
            preparedStatement = conexion.prepareStatement("UPDATE peliculas SET " + campo + " = ? WHERE " + campo + " = ?");
            preparedStatement.setString(1, contenidoFinal);
            preparedStatement.setString(2, contenidoOrigen);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasOpImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(String titulo) {
        try {
            preparedStatement = conexion.prepareStatement("DELETE FROM peliculas WHERE titulo = ?");
            preparedStatement.setString(1, titulo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PeliculasOpImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pelicula> filtrarCategoria(String categoria) {
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM peliculas  WHERE genero = ?");
            preparedStatement.setString(1, categoria);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                Pelicula pelicula = new Pelicula();
                pelicula.setTitulo(resultSet.getString(1));
                pelicula.setDirector(resultSet.getString(2));
                pelicula.setGenero(resultSet.getString(3));
                pelicula.setAnnoEstreno(resultSet.getInt(4));
                //pelicula.setIdUsuario(resultSet.getInt(5));
                peliculas.add(pelicula);
            }
            return peliculas;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public void RecuperarBLOB (String titulo) throws SQLException, IOException{
        
        try{
                File file = new File("src/imagenes/caratula.jpg");
                FileOutputStream fos = new FileOutputStream(file);                    
                Blob bin = buscarPelicula(titulo).get(0).getCaratula();
                InputStream inStream = bin.getBinaryStream();
                int size = (int)bin.length();
                byte[] buffer = new byte[size];
                int length = -1;
                while ((length = inStream.read(buffer)) != -1)
                {
                  fos.write(buffer, 0, length);                
                }                                        
            
        }
        catch (IOException ioe)
        {
            throw new IOException(ioe.getMessage());
        }
                
    }
}

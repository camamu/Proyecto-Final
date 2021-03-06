package usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventanas.Correo;

public class UsuariosOpImp implements UsuariosOp {

    private Connection conexion;
    private PreparedStatement preparedStatement;

    public UsuariosOpImp() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/peliculas_db", "carlos", "1qazZAQ!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void insertar(String nick, String passwd, String nombre,
            String apellidos, String correo) {
        try {
            preparedStatement = conexion.prepareStatement("INSERT INTO usuarios VALUES( ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, nick);
            preparedStatement.setString(2, passwd);
            preparedStatement.setString(3, nombre);
            preparedStatement.setString(4, apellidos);
            preparedStatement.setString(5, correo);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar(String nick) {
        try {
            preparedStatement = conexion.prepareStatement("DELETE FROM usuarios WHERE nick = ?");
            preparedStatement.setString(1, nick);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Usuario> consultar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM usuarios");
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setNick(resultSet.getString(1));
                usuario.setPasswd(resultSet.getString(2));
                usuario.setNombre(resultSet.getString(3));
                usuario.setApellidos(resultSet.getString(4));
                usuario.setCorreo(resultSet.getString(5));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void consultarPasswd(String nick) {
        String contraseña = "", correo = "";
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM usuarios WHERE nick = ?");
            preparedStatement.setString(1, nick);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                contraseña = resultSet.getString(2);
                correo = resultSet.getString(5);
            }
            Correo rcontraseña = new Correo("desarrollador.93.04.17@gmail.com", "nezsesszqpuqxcuk", correo, "Recuperacion de contraseña:", "Su contraseña es: "+contraseña);
            rcontraseña.sendMail();
            System.out.println(correo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Boolean login(String nick, String passwd) {
        boolean validUser = false;
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM usuarios WHERE nick = ? AND passwd = ?");
            preparedStatement.setString(1, nick);
            preparedStatement.setString(2, passwd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String cValida = resultSet.getString(2);
                validUser = (passwd.equals(cValida));
            }
            return validUser;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return validUser;
    }

    @Override
    public Boolean comprobarUsuario(String nick) {
        boolean validUser = false;
        try {
            preparedStatement = conexion.prepareStatement("SELECT * FROM usuarios WHERE nick = ?");
            preparedStatement.setString(1, nick);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String usuario = resultSet.getString(1);
                validUser = (nick.equals(usuario));
            }
            return validUser;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return validUser;
    }

}

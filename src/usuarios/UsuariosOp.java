package usuarios;

import java.util.List;

public interface UsuariosOp {

	public void insertar(String nick, String passwd, String nombre,
			String apellidos, String correo);

	public void eliminar(String nick);

	public List<Usuario> consultar();

	public void consultarPasswd(String nick);

	public Boolean login(String nick, String passwd);
        
        public Boolean comprobarUsuario(String nick);
}
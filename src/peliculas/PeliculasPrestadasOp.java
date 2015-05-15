package peliculas;

import java.sql.ResultSet;

public interface PeliculasPrestadasOp {

	public void insertar(int id, int idPelicula, String nombrePersPres,
			String recuperada, int idUsuario);

	public ResultSet consultar();
        
	public void consultarCampo(String campo, String contenido);

	public void modificar(String campo, String contenido);

	public void eliminar(int id);

}
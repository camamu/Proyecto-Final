package peliculas;

import java.util.List;

public interface PeliculasPrestadasOp {

	public void insertar(String pelicula, String usuario, String nombrePers);

	public List<PeliculasPrestadas> consultar(String usuario);
        
	public List<PeliculasPrestadas> consultarPelicula(String usuario, String titulo);
        
	public void eliminar(String usuario, String titulo);

}
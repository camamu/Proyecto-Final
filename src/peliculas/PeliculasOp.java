package peliculas;

import java.io.FileInputStream;
import java.util.List;

public interface PeliculasOp {

	public void insertar(String titulo, String director, String genero,
			int annoEstreno, FileInputStream catarula);
        
        public void insertar(String titulo, String director, String genero,
			int annoEstreno);

	public List<Pelicula> consultar();

	public List<Pelicula> buscarPelicula(String titulo);

	public void modificar(String contenidoOrigen, String titulo, String director, String genero, int annoEstreno, FileInputStream caratula);

	public void eliminar(String titulo);
        
        public List<Pelicula> filtrarCategoria(String categoria);
}
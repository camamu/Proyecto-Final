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
        
        public List<Pelicula> peliculaVista(String usuario);
        
        public List<Pelicula> peliculaFavorita(String usuario);
        
        public List<Pelicula> buscarFavorita(String usuario, String titulo);
        
        public List<Pelicula> buscarVista(String usuario, String titulo);
        
        public void marcarComoVista(String titulo);
        
        public void marcarComoFavorita(String titulo);
        
        public void eliminarFavorita(String titulo, String usuario);
        
        public void eliminarVista(String titulo, String usuario);
        
        public Boolean controlDuplicados(String titulo);
}
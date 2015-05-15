package peliculas;

import java.sql.Blob;

/**
 *
 * @author Carlos
 */
public class Pelicula {
    String titulo, director, genero;
    int annoEstreno;
    Blob caratula;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnnoEstreno() {
        return annoEstreno;
    }

    public void setAnnoEstreno(int annoEstreno) {
        this.annoEstreno = annoEstreno;
    }

    public Blob getCaratula() {
        return caratula;
    }

    public void setCaratula(Blob caratula) {
        this.caratula = caratula;
    }
    
    
}

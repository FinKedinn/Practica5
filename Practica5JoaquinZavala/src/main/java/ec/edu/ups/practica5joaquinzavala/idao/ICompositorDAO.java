package ec.edu.ups.practica5joaquinzavala.idao;

import ec.edu.ups.practica5joaquinzavala.modelo.Cancion;
import ec.edu.ups.practica5joaquinzavala.modelo.Compositor;
import java.util.List;

public interface ICompositorDAO {

    public abstract void create(Compositor obj);
    public abstract Compositor read(int codigo);
    public abstract void update(Compositor obj);
    public abstract void delete(Compositor obj);
    public List<Compositor> findAll();
    
    public abstract Compositor buscarPorTituloDeCancion(String valor);
    
    public void createCancion(Compositor compositor, int codigo, String titulo, String letra, double tiempoEnMinutos);
    public Cancion readCancion(Compositor compositor, int codigo);
    public void updateCancion(Compositor compositor, int codigo, String titulo, String letra, double tiempoEnMinutos);
    public void deleteCancion(Compositor compositor, int codigo);
    public List<Cancion> findAllCanciones(Compositor compositor);
}

package ec.edu.ups.practica5joaquinzavala.idao;

import ec.edu.ups.practica5joaquinzavala.modelo.Cantante;
import ec.edu.ups.practica5joaquinzavala.modelo.Disco;
import java.util.List;

public interface ICantanteDAO {
    
    public abstract void create(Cantante obj);
    public abstract Cantante read(int codigo);
    public abstract void update(Cantante obj);
    public abstract void delete(Cantante cantante);
    public List<Cantante> findAll();
    public abstract Cantante buscarPorNombreDeDisco(String valor);
    
    public void createDisco (Cantante cantante, int codigo, String nombre, int anioDeLanzamiento);
    public Disco readDisco(Cantante cantante, int codigo);
    public void updateDisco(Cantante cantante, int codigo, String nombre, int anioDeLanzamiento);
    public void deleteDisco(Cantante cantante, int codigo);
    public List<Disco> findAllDisco(Cantante cantante);
}

package ec.edu.ups.practica5joaquinzavala.idao;

import ec.edu.ups.practica5joaquinzavala.modelo.Compositor;
import java.util.List;

public interface ICompositorDAO {

    //Creacion de una constante para el maximo elementos de la lista
    public final int MAX_OBJECTCS = 10;

    //metodos CRUDE
    //metodo abastrac create que recibe un parametro del tipo Compositor 
    public abstract void create(Compositor obj);//C
    //metodo abastrac read que recibe un parametro del tipo int y devuelve una Compositor 

    public abstract Compositor read(int codigo);//R
    //metodo abstract update que recibe un parametro del tipo Compositor 

    public abstract void update(Compositor obj);//U
    //metodo abastract deleta que recibe un parametro del tipo Compositor 

    public abstract void delete(Compositor obj);//D

    //metodo de return de la lista de personas final
    public List<Compositor> findAll();

    //metodo para buscar un compositor por el titulo de un cancion
    public abstract Compositor buscarPorTituloDeCancion(String valor);
}

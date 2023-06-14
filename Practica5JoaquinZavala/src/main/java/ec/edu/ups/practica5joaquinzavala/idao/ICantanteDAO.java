package ec.edu.ups.practica5joaquinzavala.idao;

import ec.edu.ups.practica5joaquinzavala.modelo.Cantante;
import java.util.List;

public interface ICantanteDAO {

    //Creacion de una constante para el maximo elementos de la lista
    public final int MAX_OBJECTCS = 10;

    //metodo abastrac create que recibe un parametro del tipo Cantante 
    public abstract void create(Cantante obj);//C
    //metodo abastrac read que recibe un parametro del tipo int y devuelve una Cantante 

    public abstract Cantante read(int codigo);//R
    //metodo abstract update que recibe un parametro del tipo Cantante 

    public abstract void update(Cantante obj);//U
    //metodo abastract deleta que recibe un parametro del tipo Cantante 

    public abstract void delete(Cantante obj);//D
    //metodo de return de la lista de personas final

    public List<Cantante> findAll();

    //metodo para buscar un cantante atraves del nombre de un disco
    public abstract Cantante buscarPorNombreDeDisco(String valor);
}

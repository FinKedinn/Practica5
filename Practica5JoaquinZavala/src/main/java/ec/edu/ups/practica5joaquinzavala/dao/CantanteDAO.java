package ec.edu.ups.practica5joaquinzavala.dao;

import ec.edu.ups.practica5joaquinzavala.idao.ICantanteDAO;
import ec.edu.ups.practica5joaquinzavala.modelo.Cantante;
import ec.edu.ups.practica5joaquinzavala.modelo.Disco;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CantanteDAO implements ICantanteDAO {
    
    //contador estatico para el maximo elementos de la lista de la clase
    private static int cont = 0;
    private final int MAX_OBJECTCS = 10;
    //atributo lista cantante
    private List<Cantante> listaCantante;

    //contructor
    public CantanteDAO() {
        this.listaCantante = new ArrayList();
    }

    //sobre escritura del metodo para buscar cantante por nombre de disco
    @Override
    public Cantante buscarPorNombreDeDisco(String valor) {
        for (Cantante cantante : listaCantante) { //for each de la lista de las personas
            for (Disco disco : cantante.listarDiscografia()) {
                //comparar Strings hasta que se cumpla la condicion atraves del get
                if (disco.getNombre().equals(valor)) {
                    return cantante; //return de persona
                }
            }
        }
        return null; // si no exite, return null
    }

    //sobrescritura
    @Override
    public void create(Cantante obj) {
        if (cont < MAX_OBJECTCS) {
            listaCantante.add(obj);
            cont++;
        } else {
            System.out.println("Has llegado al limite");
        }
    }

    @Override
    public Cantante read(int codigo) {
        for (Cantante cantante : listaCantante) {
            if (cantante.getCodigo() == codigo) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante obj) {
        for (int i = 0; i < listaCantante.size(); i++) {
            Cantante cantantito = listaCantante.get(i);
            if (cantantito.getCodigo() == obj.getCodigo()) {
                listaCantante.set(i, (Cantante) obj);
                break;
            }
        }
    }

    @Override
    public void delete(Cantante obj) {
        Iterator<Cantante> it = listaCantante.iterator();
        while (it.hasNext()) {
            Cantante c = it.next();
            if (c.getCodigo() == obj.getCodigo()) {
                it.remove();
                return;
            }
        }
    }

    @Override
    public List<Cantante> findAll() {
        return listaCantante;
    }
    
     @Override
    public void createDisco(Cantante cantante, int codigo, String nombre, int anioDeLanzamiento) {
        if (listaCantante.contains(cantante)) {
            cantante.agregarDisco(new Disco(codigo, nombre, anioDeLanzamiento));
        }
    }

    @Override
    public Disco readDisco(Cantante cantante, int codigo) {
        if (listaCantante.contains(cantante)) { 
            return cantante.buscarDisco(codigo);
        }
        return null;
    }

    @Override
    public void updateDisco(Cantante cantante, int codigo, String nombre, int anioDeLanzamiento) {
        if (listaCantante.contains(cantante)) {
            cantante.actualizarDisco(new Disco(codigo, nombre, anioDeLanzamiento));
            this.update(cantante);
        }
    }

    @Override
    public void deleteDisco(Cantante cantante, int codigo) {
        if (listaCantante.contains(cantante)) {
            cantante.eliminarDisco(new Disco(codigo));
            this.update(cantante);
        }
    }

    @Override
    public List<Disco> findAllDisco(Cantante cantante) {
        if (listaCantante.contains(cantante)) { return cantante.listarDiscografia();}
        return null;
    }

}

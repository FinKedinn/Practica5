/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5joaquinzavala.dao;

import ec.edu.ups.practica5joaquinzavala.idao.ICompositorDAO;
import ec.edu.ups.practica5joaquinzavala.modelo.Cancion;
import ec.edu.ups.practica5joaquinzavala.modelo.Compositor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author estem
 */
public class CompositorDAO implements ICompositorDAO {

    //contador estatico para el maximo de elementos de la clase
    private static int cont;
    private final int MAX_OBJECTCS = 10;
    
    // atributo lista compositor
    List<Compositor> listaCompositor;

    //constructor
    public CompositorDAO() {
        this.listaCompositor = new ArrayList();
    }

    //metodo sobrescrito para buscar un compositor por un titulo de la cancion
    @Override
    public Compositor buscarPorTituloDeCancion(String valor) {
        for (Compositor compositor : listaCompositor) {  //for each de la lsita personas
            for (Cancion cancion : compositor.listarCancionesTop100Billaboar()) {
                //comparar Strings hasta que se cumpla la condicion atraves del get
                if (cancion.getTitulo().equals(valor)) {
                    return compositor; //retunr de persona
                }
            }
        }
        return null; // si no existe, return null
    }

    //metodos sobreescritos ICompositor
    @Override
    public void create(Compositor obj) {
        if (cont < MAX_OBJECTCS) {
            listaCompositor.add(obj);
            cont++;
        } else {
            System.out.println("Has llegado al limite");
        }
    }

    @Override
    public Compositor read(int codigo) {
        for (Compositor compositor : listaCompositor) {
            if (compositor.getCodigo() == codigo) {
                return compositor;
            }
        }
        return null;
    }

    @Override
    public void update(Compositor obj) {
        for (int i = 0; i < listaCompositor.size(); i++) {
            Compositor compositorsito = listaCompositor.get(i);
            if (compositorsito.getCodigo() == obj.getCodigo()) {
                listaCompositor.set(i, obj);
                break;
            }
        }
    }

    @Override
    public void delete(Compositor obj) {
        Iterator<Compositor> it = listaCompositor.iterator();
        while (it.hasNext()) {
            Compositor c = it.next();
            if (c.getCodigo() == obj.getCodigo()) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Compositor> findAll() {
        return listaCompositor;
    }@Override
    public void createCancion(Compositor compositor, int codigo, String titulo, String letra, double tiempoEnMinutos) {
        if(listaCompositor.contains(compositor)){
            compositor.agregarCancion(new Cancion(codigo, titulo, letra, tiempoEnMinutos));
            this.update(compositor);
        }
    }

    @Override
    public Cancion readCancion(Compositor compositor, int codigo) {
        if(listaCompositor.contains(compositor)){
            return compositor.buscarCancion(codigo);
        }return null;
    }

    @Override
    public void updateCancion(Compositor compositor, int codigo, String titulo, String letra, double tiempoEnMinutos) {
        if(listaCompositor.contains(compositor)){
            compositor.actualizarCancion(new Cancion(codigo, titulo, letra, tiempoEnMinutos));
            this.update(compositor);
        }
        
    }

    @Override
    public void deleteCancion(Compositor compositor, int codigo) {
        if(listaCompositor.contains(compositor)){
            compositor.eliminarCacion(new Cancion(codigo));
            this.update(compositor);
        }
    }

    @Override
    public List<Cancion> findAllCanciones(Compositor compositor) {
        if(listaCompositor.contains(compositor)){
            return compositor.listarCancionesTop100Billaboar();
        }return null;
    }
    
}

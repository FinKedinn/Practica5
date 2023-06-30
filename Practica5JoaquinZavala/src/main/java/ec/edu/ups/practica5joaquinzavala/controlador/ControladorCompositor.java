/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5joaquinzavala.controlador;

import ec.edu.ups.practica5joaquinzavala.idao.ICantanteDAO;
import ec.edu.ups.practica5joaquinzavala.idao.ICompositorDAO;
import ec.edu.ups.practica5joaquinzavala.modelo.Cancion;
import ec.edu.ups.practica5joaquinzavala.modelo.Cantante;
import ec.edu.ups.practica5joaquinzavala.modelo.Compositor;
import java.util.List;

/**
 *
 * @author estem
 */
public class ControladorCompositor {
    private Compositor compositor;
    private Cantante cantante;

    private ICompositorDAO compositorDAO;
    private ICantanteDAO cantanteDAO;

    public ControladorCompositor(ICompositorDAO compositorDAO, ICantanteDAO cantanteDAO) {
        this.compositorDAO = compositorDAO;
        this.cantanteDAO = cantanteDAO;
    }

    public void agregarCompositor(Compositor compositor) {
        compositorDAO.create(compositor);
    }

    public Compositor buscarCompositor(int codigo) {
        return compositorDAO.read(codigo);
    }

    public Compositor buscarCompositorPorCancion(String tituloDeLaCancion) {
        return this.compositor = compositorDAO.buscarPorTituloDeCancion(tituloDeLaCancion);
    }

    public boolean actualizarCompositor(Compositor compositor) {
        this.compositor = this.buscarCompositor(compositor.getCodigo());
        if (this.compositor != null) {
            compositorDAO.update(compositor);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarCompositor(Compositor compositor) {
        this.compositor = this.buscarCompositor(compositor.getCodigo());
        if (this.compositor != null) {
            compositorDAO.delete(compositor);
            return true;
        } return false;

    }

    public List<Compositor> listarCompositores() {
        return compositorDAO.findAll();
    }

    //metodo para cantante
    public void agregarCliente(Compositor compositor, Cantante cantante) {
        this.compositor = compositor;
        this.cantante = cantante;

        this.compositor.agregarCliente(this.cantante);
        compositorDAO.update(this.compositor);
    }

    public void eliminarCliente(Compositor compositor, Cantante cantante) {
        this.compositor = compositor;
        this.cantante = cantante;
        this.compositor.eliminarCliente(this.cantante);
        compositorDAO.update(this.compositor);
    }

    public List<Cantante> listarClientes(Compositor compositor) {
        return compositor.listarClente();
    }

    public void actualizarCliente(Compositor compositor, Cantante cantanteAnterior, Cantante cantanteNuevo) {
        this.compositor = compositor;
        this.eliminarCliente(this.compositor, cantanteAnterior);
        this.agregarCliente(this.compositor, cantanteNuevo);
    }

    public Cantante buscarCliente(Compositor compositor, int codigo) {
        return compositor.buscarCliente(codigo);
    }

    //metodos para canciones
    public void agregarCancion(Compositor compositor, int codigo, String titulo, String letra, double tiempoEnMinutos) {
        this.compositor = compositor;
        compositorDAO.createCancion(this.compositor, codigo, titulo, letra, tiempoEnMinutos);
        compositorDAO.update(this.compositor);
    }

    public Cancion buscarCancion(Compositor compositor, int codigo) {
        this.compositor = compositor;
        return compositorDAO.readCancion(this.compositor, codigo);
    }

    public boolean eliminarCancion(Compositor compositor, int codigo) {
        this.compositor = compositor;
        Cancion cancion = this.buscarCancion(this.compositor, codigo);
        if (cancion != null) {
            compositorDAO.deleteCancion(this.compositor, codigo);
            compositorDAO.update(this.compositor);
            return true;
        } else {
            return false;
        }

    }

    public boolean actualizarCancion(Compositor compositor, int codigo, String titulo, String letra, double tiempoEnMinutos) {
        this.compositor = compositor;
        Cancion cancion = this.buscarCancion(compositor, codigo);
        if (cancion != null) {
            compositorDAO.updateCancion(this.compositor, codigo, titulo, letra, tiempoEnMinutos);
            compositorDAO.update(this.compositor);
            return true;
        } else {
            return false;
        }
    }

    public List<Cancion> listarCanciones(Compositor compositor) {
        this.compositor = compositor;
        return compositorDAO.findAllCanciones(this.compositor);
    }
}

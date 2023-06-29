/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica5joaquinzavala.controlador;

import ec.edu.ups.practica5joaquinzavala.idao.ICantanteDAO;
import ec.edu.ups.practica5joaquinzavala.modelo.Cantante;
import ec.edu.ups.practica5joaquinzavala.modelo.Disco;
import java.util.List;

/**
 *
 * @author estem
 */
public class ControladorCantante {
    private Cantante cantante;
    private ICantanteDAO cantanteDAO;

    public ControladorCantante(ICantanteDAO cantanteDAO) {
        this.cantanteDAO = cantanteDAO;
    }

    public void agregarCantante(Cantante cantante) {
        cantanteDAO.create(cantante);
    }

    public Cantante buscarCantante(int codigo) {
        this.cantante = cantanteDAO.read(codigo);
        return cantante;
    }

    public boolean actualizarCantante(Cantante cantante) {
        this.cantante = this.buscarCantante(cantante.getCodigo());
        if (this.cantante != null) {
            cantanteDAO.update(cantante);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarCantante(Cantante cantante) {
        this.cantante = this.buscarCantante(cantante.getCodigo());
        if (this.cantante != null) {
            cantanteDAO.delete(this.cantante);
            return true;
        } else {
            return false;
        }

    }

    public List<Cantante> listar() {
        return cantanteDAO.findAll();
    }
    
    public Cantante buscarCantantePorDisco(String nombreDisco) {
        return cantanteDAO.buscarPorNombreDeDisco(nombreDisco);
    }
    
    //metodos de agregacion

    public void ingresarDisco(Cantante cantante, int codigo, String nombre, int anioDeLanzamiento) {
        this.cantante = cantante;
        cantanteDAO.createDisco(this.cantante, codigo, nombre, anioDeLanzamiento);
        cantanteDAO.update(this.cantante);
    }

    public Disco buscarDisco(Cantante cantante, int codigo) {
        this.cantante = cantante;
        return cantanteDAO.readDisco(this.cantante, codigo);
    }

    public boolean eliminarDisco(Cantante cantante, int codigo, String nombre, int anioDeLanzamiento) {
        this.cantante = cantante;
        Disco disco = this.buscarDisco(this.cantante, codigo);
        if (disco != null) {
            cantanteDAO.deleteDisco(this.cantante, codigo);
            cantanteDAO.update(this.cantante);
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarDisco(Cantante cantante, int codigo, String nombre, int anioDeLanzamiento) {
        this.cantante = cantante;
        Disco disco = this.buscarDisco(cantante, codigo);
        if (disco != null) {
            cantanteDAO.updateDisco(this.cantante, codigo, nombre, anioDeLanzamiento);
            cantanteDAO.update(this.cantante);
            return true;
        } else {
            return false;
        }
    }

    public List<Disco> listarDiscos(Cantante cantante) {
        this.cantante = cantante;
        return cantanteDAO.findAllDisco(this.cantante);
    }
}

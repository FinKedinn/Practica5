package com.mycompany.trabajoenclase2joaquinzavala;

import java.util.ArrayList;

public class TrabajoEnClase2JoaquinZavala {

    public static void main(String[] args) {
        System.out.println("Colas y Pilas implementacion Generica");

        ColaTarea<String> colaTarea = new ColaTarea<>();
        ColaTarea<Integer> colaTareaInt = new ColaTarea<>();
        ColaTarea<int[]> colaTareaArregloEnteros = new ColaTarea<>();
        ColaTarea<String[]> colaTareaArregloString = new ColaTarea<>();

        PilaTareas<Integer> pilaTareas = new PilaTareas();
        PilaTareas<ColaTarea> pilaTareasDeCola = new PilaTareas();

        pilaTareas.agregarTarea(new Tarea(1, 1));
        pilaTareas.agregarTarea(new Tarea(1, 2));
        pilaTareas.agregarTarea(new Tarea(1, 3));

        colaTareaArregloEnteros.agregarTarea(new Tarea(1, new int[]{1, 2, 3}));
        colaTareaArregloEnteros.agregarTarea(new Tarea(2, new int[]{4, 5, 6}));
        colaTareaArregloEnteros.agregarTarea(new Tarea(3, new int[]{7, 8, 9}));

        pilaTareasDeCola.agregarTarea(new Tarea(1, colaTarea));
        pilaTareasDeCola.agregarTarea(new Tarea(2, colaTareaArregloEnteros));
        pilaTareasDeCola.agregarTarea(new Tarea(3, colaTareaInt));
        pilaTareasDeCola.agregarTarea(new Tarea(4, colaTareaArregloString));

        colaTarea.agregarTarea(new Tarea(1, "Tarea 1"));
        colaTarea.agregarTarea(new Tarea(2, "Tarea 2"));
        colaTarea.agregarTarea(new Tarea(3, "Tarea 3"));

        colaTareaInt.agregarTarea(new Tarea(1, 1));
        colaTareaInt.agregarTarea(new Tarea(2, 2));
        colaTareaInt.agregarTarea(new Tarea(3, 3));

        pilaTareas.agregarTarea(new Tarea(6, 6));
        pilaTareas.agregarTarea(new Tarea(7, 7));
        pilaTareas.agregarTarea(new Tarea(8, 8));

        System.out.println("COLA TAREAS");
        while (!colaTarea.estaVacia()) {
            Tarea<String> tareaProcesada = colaTarea.procesarTarea();

            System.out.println("Procesando tarea de la cola: \n\t Sale--> " + tareaProcesada.getId() + " - " + tareaProcesada.getAtributo());
        }
        while (!colaTareaInt.estaVacia()) {
            Tarea<Integer> tareaProcesada = colaTareaInt.procesarTarea();

            System.out.println("Procesando tarea de la cola: \n\t Sale--> " + tareaProcesada.getId() + " - " + tareaProcesada.getAtributo());
        }
        while (!colaTareaArregloEnteros.estaVacia()) {
            Tarea<int[]> tareaProcesada = colaTareaArregloEnteros.procesarTarea();

            System.out.println("Procesando tarea de la cola: \n\t Sale--> " + tareaProcesada.getId() + " - " + tareaProcesada.getAtributo());
        }

        System.out.println("PILA TAREAS");
        while (!pilaTareas.estaVacia()) {
            Tarea<Integer> tareaProcesada = pilaTareas.procesarTarea();

            System.out.println("Procesando tarea de la pila: \n\t Sale--> " + tareaProcesada.getId() + " - " + tareaProcesada.getAtributo());

        }
    }

}

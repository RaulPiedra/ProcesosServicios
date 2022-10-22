package com.terfezio.Tema2;

public class Actividad2_1 {
    public static void main(String[] args) {
        //Devuelve un objeto Thread del hilo en ejecución:
        Thread thread = Thread.currentThread();
        //Sacamos por pantalla diversa información sobre el hilo:
        System.out.println("¿Está vivo?: " + thread.isAlive());
        System.out.println("Nombre: " + thread.getName());
        System.out.println("Identificador: " + thread.getId());
        System.out.println("Estado: " + thread.getState());
        System.out.println("¿Es daemon?: " + thread.isDaemon());
        System.out.println("Prioridad: " + thread.getPriority());
    }
}

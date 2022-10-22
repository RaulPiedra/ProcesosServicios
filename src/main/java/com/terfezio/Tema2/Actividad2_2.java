package com.terfezio.Tema2;

public class Actividad2_2 {
    public static void main(String[] args) {
        //La clase Thread provee tres constantes para la prioridad:
        //Thread.MAX_PRIORITY;
        //Thread.MIN_PRIORITY;
        //Thread.NORM_PRIORITY
        //Veamos sus valores:
        System.out.println("Máxima prioridad: " + Thread.MAX_PRIORITY);
        System.out.println("Mínima prioridad: " + Thread.MIN_PRIORITY);
        System.out.println("Prioridad normal: " + Thread.NORM_PRIORITY);

        //Vamos a crear un objeto Thread de este hilo de ejecución:
        Thread thread = Thread.currentThread();

        //Vamos a ver su prioridad por defecto:
        System.out.println("Prioridad por defecto: " + thread.getPriority());

        //Vamos a cambiarla a la máxima y comprobar que ha cambiado:
        System.out.println();
        System.out.println("Cambiamos a máxima prioridad:");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Máxima prioridad: " + thread.getPriority());

        //Ahora cambiamos a la mínima y comprobamos:
        System.out.println();
        System.out.println("Cambiamos a mínima prioridad:");
        thread.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Mínima prioridad: " + thread.getPriority());
    }
}

package com.terfezio.Tema2.Actividad2_3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hilo extends Thread{
    private final String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }
    public void run() {
        System.out.println("Me llamo " + nombre + " voy a empezar a trabajar.");
        while (true) {
            int time = (int) (Math.random() * 10000 + 1);
            System.out.println("Soy el hilo " + nombre + " y estoy trabajando.");
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        Hilo[] hilos = new Hilo[5];

        for (int i = 0; i < hilos.length; i++) {
            System.out.print("Introduzca el nombre del hilo: ");
            String nombre = kb.readLine();
            hilos[i] = new Hilo(nombre);
        }

        for (Hilo hilo: hilos) {
            hilo.start();
        }

    }
}

package com.terfezio.Tema2.Actividad2_3;

public class HilosCoopNoSinc {
    private static final int NUM_HILOS = 10;
    private static final int CUENTA_TOTAL = 100000;

    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread[] hilos = new Thread[NUM_HILOS];

        for (int i = 0; i < NUM_HILOS; i++) {
            Thread thread = new Thread(new Hilo(i, CUENTA_TOTAL / NUM_HILOS, contador));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hilos[i] = thread;
        }
        for (Thread thread: hilos) {
            /*try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            System.out.printf("Cuenta global: %s\n", contador.getCuenta());
        }
    }
}

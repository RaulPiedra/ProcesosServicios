package com.terfezio.Tema2.Actividad2_3;

public class Hilo implements Runnable {
    int numHilo;
    int miParte;
    int miCuenta;
    private final Contador contador;

    public Hilo(int numHilo, int miParte, Contador contador) {
        this.numHilo = numHilo;
        this.miParte = miParte;
        this.contador = contador;
    }
    @Override
    public void run() {
        for (int i = 0; i < miParte; i++) {
            this.contador.incrementa();
            miCuenta++;
        }
        System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilo, getMiCuenta());
    }

    private int getMiCuenta() {
        return miCuenta;
    }
}

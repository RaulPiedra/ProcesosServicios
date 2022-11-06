package com.terfezio.Tema2;

public class Impresor extends Thread {
    private static int acumulador = 0;
    // Objeto final y estático creado para obtener el lock de una sección
    private static final Object countLock = new Object();
    private int contador;
    private static void ajustaAcumulador() {
            acumulador -= 500;
    }
    private void ajustaContador() {
        contador -= 500;
    }
    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {

            contador++;
            synchronized (countLock) {
                acumulador++;
                if (acumulador == 600) {
                    ajustaAcumulador();
                }
            }
                if (contador == 600) {
                    ajustaContador();
                }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Impresor().start();
        }
        //Dejamos tiempo para que acaben los hilos
        Thread.sleep(1000);
        //Sacamos el valor del acumulador (debe valer 500)
        System.out.println(acumulador);
    }
}

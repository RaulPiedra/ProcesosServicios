package com.terfezio.Tema2;

public class NumeroOculto extends Thread {
    public static int numeroOculto = 0;
    public static boolean acertado = false;
    private final String nombre;
    public NumeroOculto(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run() {
        int numeroPropuesto;
        int respuesta = -100;
        do {
            numeroPropuesto = (int) (Math.random() * 100 + 1);
            System.out.println("Soy el hilo " + this.nombre + " y propongo el " + numeroPropuesto);
            respuesta = this.propuestaNumero(numeroPropuesto);

            System.out.println("Soy el hilo " + this.nombre + " y he recibido de respuesta el " + respuesta);
            if (respuesta == 1) {
            System.out.println("Soy el hilo " + this.nombre + " y he ganado");
        }
        } while (respuesta != -1);
    }

    public int propuestaNumero(int numeroPropuesto) {
        int respuesta = 0;
        if (acertado) {
            respuesta = -1;
        }
        else if (numeroPropuesto == numeroOculto) {
            respuesta = 1;
            acertado = true;
        }
        return  respuesta;
    }

    public static void main(String[] args) {
        numeroOculto = (int) (Math.random() * 100 + 1);
        System.out.println("El número que tienen que acertar es el " + numeroOculto);

        NumeroOculto[] nmo = new NumeroOculto[10];

        for (int i = 0; i < nmo.length; i++) {
            nmo[i] = new NumeroOculto("Hilo " + i);

        }
        for (NumeroOculto numeroOculto1: nmo) {
            numeroOculto1.start();
        }
    }
}

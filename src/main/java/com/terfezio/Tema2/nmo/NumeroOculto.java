package com.terfezio.Tema2.nmo;

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
        int respuesta;

        do {
            numeroPropuesto = (int) (Math.random() * 100 + 1);
            respuesta = this.propuestaNumero(numeroPropuesto);
            //System.out.println(this.nombre + ": " + numeroPropuesto);

           /*try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }*/
            if (respuesta == 1) {
                System.out.println("Soy el hilo " + this.nombre + " y he ganado");
            }
        } while (respuesta == 0);

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
            nmo[i].start();

        }
    }
}


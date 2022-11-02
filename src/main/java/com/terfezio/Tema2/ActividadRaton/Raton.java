package com.terfezio.Tema2.ActividadRaton;
public class Raton implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;

    public Raton (String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion=tiempoAlimentacion;
    }

    public void run() {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre) ;
            Thread.sleep(tiempoAlimentacion*1000);
            System.out.printf ("El ratón %s ha terminado de alimentarse%n",nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        Thread fievel = new Thread(new Raton("Fievel", 4));
        Thread jerry = new Thread( new Raton("Jerry", 5));
        Thread pinky = new Thread( new Raton("Pinky", 3));
        Thread mickey = new Thread( new Raton("Mickey", 6));
        //Raton fievel = new Raton ("Fievel",4) ;
        //Raton jerry = new Raton ( "Jerry", 6);
        //Raton pinky = new Raton ( "Pinky", 3);
        //Raton mickey = new Raton ("Mickey", 6) ;
        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
    }
}
/*
Resultados:

El ratón Fievel ha comenzado a alimentarse
El ratón Pinky ha comenzado a alimentarse
El ratón Mickey ha comenzado a alimentarse
El ratón Jerry ha comenzado a alimentarse
El ratón Pinky ha terminado de alimentarse
El ratón Fievel ha terminado de alimentarse
El ratón Jerry ha terminado de alimentarse
El ratón Mickey ha terminado de alimentarse

El ratón Fievel ha comenzado a alimentarse
El ratón Mickey ha comenzado a alimentarse
El ratón Pinky ha comenzado a alimentarse
El ratón Jerry ha comenzado a alimentarse
El ratón Pinky ha terminado de alimentarse
El ratón Fievel ha terminado de alimentarse
El ratón Jerry ha terminado de alimentarse
El ratón Mickey ha terminado de alimentarse

El ratón Fievel ha comenzado a alimentarse
El ratón Mickey ha comenzado a alimentarse
El ratón Pinky ha comenzado a alimentarse
El ratón Jerry ha comenzado a alimentarse
El ratón Pinky ha terminado de alimentarse
El ratón Fievel ha terminado de alimentarse
El ratón Jerry ha terminado de alimentarse
El ratón Mickey ha terminado de alimentarse

El ratón Fievel ha comenzado a alimentarse
El ratón Pinky ha comenzado a alimentarse
El ratón Mickey ha comenzado a alimentarse
El ratón Jerry ha comenzado a alimentarse
El ratón Pinky ha terminado de alimentarse
El ratón Fievel ha terminado de alimentarse
El ratón Jerry ha terminado de alimentarse
El ratón Mickey ha terminado de alimentarse

Se observa que los mensajes de ha comenzado a alimentarse aparecen a la vez (aparentemente)
y los de ha terminado de alimentarse aparecen en orden creciente del tiempo asignado a comer


 */
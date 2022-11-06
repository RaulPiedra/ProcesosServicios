package com.terfezio.Tema2.Contadores;

public class IncrementaContadores implements Runnable {
    private Contadores contadores;
    private String nombre;
    private int parte;
    public IncrementaContadores(Contadores contadores, String nombre, int parte) {
        super();
        this.contadores = contadores;
        this.nombre = nombre;
        this.parte = parte;
    }
    @Override
    public void run() {
        System.out.println("Soy el hilo " + nombre + " y empiezo a incrementar el primer contador");

        for (int i = 0; i < parte; i++) {
            contadores.incrementar1();
        }
        System.out.println("Soy el hilo " + nombre + " y he dejado el contador1 en " + contadores.getContador1());
        System.out.println("Soy el hilo " + nombre + " y empiezo a incrementar el segundo contador");

        for (int i = 0; i < parte; i++) {
            contadores.incrementar2();
        }
        System.out.println("Soy el hilo " + nombre + " y he dejado el contador 2 en " + contadores.getContador2());
    }

    public static void main(String[] args) {
        Contadores contadores1 = new Contadores();
        final int parte = 100_000_000 / 10;

        Thread[] hilos = new Thread[10];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(new IncrementaContadores(contadores1, "Hilo " + i, parte));
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }

    }
}
/* Resultado:
Soy el hilo Hilo 0 y empiezo a incrementar el primer contador
Soy el hilo Hilo 9 y empiezo a incrementar el primer contador
Soy el hilo Hilo 2 y empiezo a incrementar el primer contador
Soy el hilo Hilo 5 y empiezo a incrementar el primer contador
Soy el hilo Hilo 7 y empiezo a incrementar el primer contador
Soy el hilo Hilo 8 y empiezo a incrementar el primer contador
Soy el hilo Hilo 1 y empiezo a incrementar el primer contador
Soy el hilo Hilo 4 y empiezo a incrementar el primer contador
Soy el hilo Hilo 6 y empiezo a incrementar el primer contador
Soy el hilo Hilo 3 y empiezo a incrementar el primer contador
Soy el hilo Hilo 4 y he dejado el contador1 en 83920091
Soy el hilo Hilo 4 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 1 y he dejado el contador1 en 86619311
Soy el hilo Hilo 1 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 4 y he dejado el contador 2 en 11758666
Soy el hilo Hilo 1 y he dejado el contador 2 en 20000000
Soy el hilo Hilo 0 y he dejado el contador1 en 95680906
Soy el hilo Hilo 0 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 7 y he dejado el contador1 en 96308186
Soy el hilo Hilo 7 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 2 y he dejado el contador1 en 96972676
Soy el hilo Hilo 2 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 8 y he dejado el contador1 en 98325685
Soy el hilo Hilo 5 y he dejado el contador1 en 98326011
Soy el hilo Hilo 8 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 5 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 3 y he dejado el contador1 en 98797150
Soy el hilo Hilo 3 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 6 y he dejado el contador1 en 99015538
Soy el hilo Hilo 6 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 9 y he dejado el contador1 en 100000000
Soy el hilo Hilo 9 y empiezo a incrementar el segundo contador
Soy el hilo Hilo 0 y he dejado el contador 2 en 69621490
Soy el hilo Hilo 8 y he dejado el contador 2 en 93995832
Soy el hilo Hilo 7 y he dejado el contador 2 en 94223371
Soy el hilo Hilo 6 y he dejado el contador 2 en 96658884
Soy el hilo Hilo 5 y he dejado el contador 2 en 97100100
Soy el hilo Hilo 9 y he dejado el contador 2 en 97763649
Soy el hilo Hilo 3 y he dejado el contador 2 en 99991757
Soy el hilo Hilo 2 y he dejado el contador 2 en 100000000

 */
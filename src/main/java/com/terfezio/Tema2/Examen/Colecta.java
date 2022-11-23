package com.terfezio.Tema2.Examen;

public class Colecta {
    private int cantidadRecolectada;
    public Colecta() {
        cantidadRecolectada = 0;
    }
    public synchronized void addColecta(int colecta) {
        cantidadRecolectada = cantidadRecolectada + colecta;
    }
    public synchronized int getCantidadRecolectada() {
        return cantidadRecolectada;
    }
}

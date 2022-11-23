package com.terfezio.Tema2.Examen;


public class Recolectores extends Thread{
    private final Colecta colecta;
    public Recolectores(Colecta colecta) {
        this.colecta = colecta;
    }
    @Override
    public void run() {
        int totalDelHilo = 0;
        while (colecta.getCantidadRecolectada() < 2000) {

            System.out.println("Hilo " + this.getName() + " inicia la recolecta");
            int sleep = (int) (Math.random() * 190 + 11);
            try {

                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (colecta.getCantidadRecolectada() < 2000){
                int recolecta = (int) (Math.random() * 20 + 6);
                colecta.addColecta(recolecta);
                totalDelHilo = totalDelHilo + recolecta;
                System.out.println("Hilo " + this.getName() + " he recolectado " + recolecta + " en " + sleep + " ms. Total:" + colecta.getCantidadRecolectada());
            }


        }
        System.out.println("Hilo " + this.getName() + " ha parado la recolecta. Cantidad recolectada: " + totalDelHilo );
    }

    public static void main(String[] args) {
        final Colecta colecta = new Colecta();
        Recolectores[] recolectores = new Recolectores[5];

        for (int i = 0; i < recolectores.length; i++) {
            recolectores[i] = new Recolectores(colecta);
            recolectores[i].start();
        }
    }

}


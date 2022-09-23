package com.terfezio;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.io. IOException;

public class ProcessLauncher2 {
    public static int MAX_TIEMPO = 5000;

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder(
                new String[]{"find", "/home/raul", "-name", "\"*\"" });
        System.out.printf ("Se ejecuta comando: %s\n", Arrays.toString(args));
        pb.inheritIO();

        pb.redirectErrorStream(true);

        try {
            Process p = pb.start();


            if (!p.waitFor (MAX_TIEMPO, TimeUnit.MILLISECONDS)) {
                p. destroy();
                System.out.printf("AVISO: No ha terminado en %d ms\n",
                        MAX_TIEMPO) ;
            }

        }   catch (IOException e) {
            System.err.println("Error durante eiecución. Información detallada");
            System.err.println("----------------------------------------------");
            e.printStackTrace();
            System.err.println("-----------------------------------------------");
            System.exit(1);
        }
        catch (InterruptedException ex) {
            System.err.println("Proceso interrumpido") ;
            System.exit(2);
        }
    }
}

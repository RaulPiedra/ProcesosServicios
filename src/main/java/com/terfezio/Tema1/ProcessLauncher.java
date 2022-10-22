package com.terfezio.Tema1;

import java.io.IOException;
import java.util.Arrays;

public class ProcessLauncher {


    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debe indicarse comando a ejecutar.");
            System.exit(1);
        }
        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();

        try {
            Process p = pb.start();
            int codRet = p.waitFor();
            System.out.println("La ejecución de " + Arrays.toString(args)
                    + " devuelve " + codRet
                    + " " + (codRet == 0 ? "(ejecución correcta)" : "(ERROR)"));
        } catch (IOException e) {
            System.err.println("Error durante eiecución del proceso");
            System.err.println("Informacióndetallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }
    }
}


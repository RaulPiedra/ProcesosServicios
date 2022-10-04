package com.terfezio;

import java.io.File;
import java.io.IOException;

public class Ejercicio1_6_2 {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.out.println("Comando invalido. Uso: ");
            System.out.println("comando origen texto destino");
        }
        else {
            File outputFile = new File(args[2]);
            ProcessBuilder processBuilder = new ProcessBuilder("grep", args[2], args[1]);
            //processBuilder.inheritIO();

            processBuilder.directory(new File("/home/raul/"));
            processBuilder.redirectOutput(outputFile);
            processBuilder.start();

        }
    }
}

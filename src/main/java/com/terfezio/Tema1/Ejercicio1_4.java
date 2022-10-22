package com.terfezio.Tema1;

import java.io.File;
import java.io.IOException;
public class Ejercicio1_4 {
    public static void main(String[] args) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder("ls");
        String defDir = String.valueOf(processBuilder.directory());
        System.out.println("El directorio por defecto es: " + defDir);
        processBuilder.start();

        ProcessBuilder processBuilder1 = new ProcessBuilder("ls");
        System.out.println("Cambiamos el directorio a /home/raul");
        processBuilder1.directory(new File("/home/raul"));
        defDir = String.valueOf(processBuilder1.directory());
        System.out.println("El nuevo directorio es: " + defDir);
        processBuilder1.start();

    }
}

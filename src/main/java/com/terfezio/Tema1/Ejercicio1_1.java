package com.terfezio.Tema1;

import java.io.IOException;

public class Ejercicio1_1 {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Se necesita al menos un argumento");
            System.exit(1);
        }

        Runtime.getRuntime().exec(args);

    }

}

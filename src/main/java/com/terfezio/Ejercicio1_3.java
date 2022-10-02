package com.terfezio;

import java.io.IOException;

public class Ejercicio1_3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(args);
        while (process.isAlive()) {
            System.out.println("It's alive");
            Thread.sleep(3000);
        }
        System.out.println("It's dead");
    }
}

package com.terfezio;

import java.io.File;
import java.io.IOException;

public class ProcessId {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Debe introducir un argumento.");

        } else {

            ProcessBuilder processBuilder = new ProcessBuilder(args[0]);
            processBuilder.inheritIO();
            processBuilder.directory(new File("/home/raul/"));

            Process process = processBuilder.start();

            System.out.println(process.pid());

        }
    }
}

package com.terfezio.Tema1;

import java.io.File;

import java.io.IOException;

//Examen

public class ProcessId {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {

            System.out.println("Debe introducir un argumento.");


        } else {


            ProcessBuilder processBuilder = new ProcessBuilder(args[0]);


            Process process = processBuilder.start();

            System.out.println("El PID es : " + process.pid());


        }

    }

}
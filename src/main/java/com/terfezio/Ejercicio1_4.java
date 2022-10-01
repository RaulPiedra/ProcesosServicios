package com.terfezio;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Ejercicio1_4 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        processBuilder.inheritIO();
        processBuilder.directory(new File("/"));
        System.out.printf("Ejecucion en directorio: %s%s%s", processBuilder.directory(),System.getProperties().get("user.dir"),"hola");
        processBuilder.start();


        System.out.println(System.getProperties().get("user.dir"));
        Map<String, String> environment = processBuilder.environment();
        /*for (Map.Entry<String,String> entry : environment.entrySet()){
            if (entry.getKey().equals("PWD")) {
                System.out.println(entry.getValue());
            }
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        }*/



        //environment.forEach((key, value) -> System.out.println(key + value));
        //processBuilder.command("ls");




    }

}

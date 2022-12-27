package com.terfezio.tema3.fileserver2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient {

    public static void main(String[] args) throws UnknownHostException {
        // Definimos los parámetros de conexión
        InetAddress direccion; // La IP o Dirección de conexión

        int PUERTO = 5000;  // Puerto de conexión

        System.out.println("Cliente conectando...");
        direccion = InetAddress.getLocalHost();

        try (Socket server = new Socket(direccion, PUERTO);

             InputStream inputStream = server.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

             OutputStream outputStream = server.getOutputStream();
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

            System.out.println("Conexión realizada con éxito");


            ClientOutput clientOutput = new ClientOutput(bufferedReader);
            clientOutput.start();

            ClientInput clientInput = new ClientInput(bufferedWriter);
            clientInput.start();

            clientInput.join();
            clientOutput.join();

            System.out.println("Closing...");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

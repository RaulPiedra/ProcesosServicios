package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.*;

public class FileClient {

    public static void main(String[] args) {
        // Definimos los parámetros de conexión
        InetAddress direccion; // La IP o Dirección de conexión
        Socket servidor; // Socket para conectarnos a un servidor u otra máquina
        int PUERTO = 5000;  // Puerto de conexión

        System.out.println("Cliente conectando...");

        try {
            // Vamos a indicar la dirección de conexión
            direccion = InetAddress.getLocalHost(); // dirección local (localhost)
            // Nos conectamos al servidor: dirección y puerto
            servidor = new Socket(direccion, PUERTO);
            // Operamos con la conexión. En este caso recibimos los datos que nos mandan
            System.out.println("Conexión realizada con éxito");

            BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introduzca ruta y nombre de un archivo: ");
            String filePath = kb.readLine();

            OutputStream outputStream = servidor.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(filePath + "\n");            
            bufferedWriter.flush();

            InputStream inputStream = servidor.getInputStream();            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            String line;
            System.out.println("===Inicio del archivo=============");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                
            }
            System.out.println("===Fin del archivo================");

            servidor.close();
            System.out.println("Cliente cerrando la conexión");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

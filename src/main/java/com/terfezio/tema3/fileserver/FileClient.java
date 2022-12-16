package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.*;

public class FileClient {

    public static void main(String[] args) {
        // Definimos los parámetros de conexión
        InetAddress direccion; // La IP o Dirección de conexión
        Socket servidor; // Socket para conectarnos a un servidor u otra máquina
        int numCliente = 0; // Mi número de cliente
        int PUERTO = 5000;  // Puerto de conexión

        System.out.println("Soy el cliente e intento conectarme");

        try {
            // Vamos a indicar la dirección de conexión
            direccion = InetAddress.getLocalHost(); // dirección local (localhost)
            // Nos conectamos al servidor: dirección y puerto
            servidor = new Socket(direccion, PUERTO);
            // Operamos con la conexión. En este caso recibimos los datos que nos mandan
            System.out.println("Conexión realizada con éxito");
            //BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
            //System.out.print("Introduzca ruta y nombre de un archivo: ");
            //String filePath = kb.readLine();

            //OutputStream outputStream = servidor.getOutputStream();
            //DataOutputStream writer = new DataOutputStream(outputStream);
            //writer.writeUTF(filePath);

            InputStream inputStream = servidor.getInputStream();
            //BufferedReader fileBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //String line = fileBufferedReader.readLine();
            //while (line != null) {
            //    System.out.println(line);
            //    line = fileBufferedReader.readLine();
            //}
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println(dataInputStream.readUTF());

            servidor.close();
            System.out.println("Soy el cliente y cierro la conexión");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

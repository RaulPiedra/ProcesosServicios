package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class FileClient2 {
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
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            InputStream inputStream = servidor.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            dataOutputStream.writeUTF(filePath);

            String fileContent = dataInputStream.readUTF();
            System.out.println(fileContent);

            dataInputStream.close();
            dataOutputStream.close();

            inputStream.close();
            outputStream.close();


            servidor.close();
            System.out.println("Cliente cerrando la conexión");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

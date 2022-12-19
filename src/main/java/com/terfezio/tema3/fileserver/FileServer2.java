package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServer2 {
    public static void main(String[] args) {
        final int PUERTO = 5000;
        int numCliente = 0;
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            System.out.println("Servidor ejecutándose en el puerto: " + PUERTO);


            while(true) {
                numCliente++;
                Socket socketClient = serverSocket.accept();
                System.out.println("\t Cliente número: " + numCliente);

                InputStream inputStream = socketClient.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);


                OutputStream outputStream = socketClient.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


                String filePath = dataInputStream.readUTF();

               Path path = Path.of(filePath);
               String fileContent = Files.readString(path);
               dataOutputStream.writeUTF(fileContent);

               dataOutputStream.close();
               dataInputStream.close();
               inputStream.close();
               outputStream.close();

                socketClient.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}


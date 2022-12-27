package com.terfezio.tema3.fileserver2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    //utf -ñññññññ
    public static void main(String[] args) {
        final int PUERTO = 5000;
        int numCliente = 0;
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            System.out.println("Servidor ejecutándose en el puerto: " + PUERTO);


            while(true) {
                numCliente++;
                Socket socketClient = serverSocket.accept();
                System.out.println("\t Cliente número: " + numCliente);

                UserThread userThread = new UserThread(socketClient);
                userThread.start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}


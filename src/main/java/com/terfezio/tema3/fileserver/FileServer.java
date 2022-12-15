package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.*;

public class FileServer {
    private ServerSocket serverSocket;
    private Socket socketClient;
    private static final int PORT = 5000;
    private int numCliente;

    public FileServer() {

    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Chat Server is listening on port " + PORT);

            do {
                numCliente++;
                socketClient = serverSocket.accept();
                System.out.println("\t Llega el cliente: " + numCliente);

                DataOutputStream ps = new DataOutputStream(socketClient.getOutputStream());
                ps.writeUTF("Usted es mi cliente: "+numCliente);
                UserThread newUser = new UserThread(socketClient, this);
                newUser.start();
                socketClient.close();
            } while (true);

        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {

           FileServer fileServer = new FileServer();
           fileServer.execute();
    }
}


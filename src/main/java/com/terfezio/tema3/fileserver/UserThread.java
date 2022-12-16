package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.Socket;

public class UserThread extends Thread{
    private final Socket socket;
    private final FileServer server;

    public UserThread(Socket socket, FileServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            DataOutputStream writer = new DataOutputStream(output);
            writer.writeUTF("hola");

            //String filePath = reader.readLine();
            //System.out.println(filePath);
            String filePath = "C:\\Users\\raul\\IdeaProjects\\ProcesosServicios\\src\\main\\java\\com\\terfezio\\tema3\\fileserver\\FileClient.java";
            String firstLine = reader.readLine();
            System.out.println("First line: " + firstLine);

            BufferedReader fileBufferedReader = new BufferedReader(new FileReader(filePath));
            String line = fileBufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                writer.writeUTF(line);
                line = fileBufferedReader.readLine();
            }
            socket.close();

        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.Socket;

public class UserThread extends Thread{
    private final Socket socket;
    private final FileServer server;
    private PrintWriter writer;

    public UserThread(Socket socket, FileServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);

        } catch (IOException ex) {
            System.out.println("Error in UserThread: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

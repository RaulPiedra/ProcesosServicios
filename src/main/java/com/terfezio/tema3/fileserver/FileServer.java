package com.terfezio.tema3.fileserver;

import java.io.*;
import java.net.*;

public class FileServer {
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
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                OutputStream output = socketClient.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(output);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String filePath = bufferedReader.readLine();

                File file = new File(filePath);

                if (file.exists() && file.isFile()) {
                    BufferedReader fileBufferedReader = new BufferedReader(new FileReader(file));
                    String line;

                    while ((line = fileBufferedReader.readLine()) != null) {
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                    }
                    fileBufferedReader.close();
                }
                else {
                    bufferedWriter.write("Error: archivo no encontrado o no es archivo");
                }

                bufferedWriter.close();
                bufferedReader.close();
                socketClient.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}


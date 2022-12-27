package com.terfezio.tema3.fileserver2;

import java.io.*;
import java.net.Socket;

public class UserThread extends Thread{
    private final Socket socketClient;
    private final InputStream inputStream;
    private final InputStreamReader inputStreamReader;
    private final BufferedReader bufferedReader;
    private final OutputStream outputStream;
    private final OutputStreamWriter outputStreamWriter;
    private final BufferedWriter bufferedWriter;

    public UserThread(Socket socketClient) throws IOException {
        this.socketClient = socketClient;

        inputStream = socketClient.getInputStream();
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);

        outputStream = socketClient.getOutputStream();
        outputStreamWriter = new OutputStreamWriter(outputStream);
        bufferedWriter = new BufferedWriter(outputStreamWriter);
    }

    public void run() {

        try {

            String command = bufferedReader.readLine();
            while (!command.equals(":q")) {
                this.runCommand(command);
                command = bufferedReader.readLine();
            }


            this.closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() throws IOException {
        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        socketClient.close();
    }

    private void runCommand(String command) throws IOException {
        switch (command) {
            case ":ls" -> {
                bufferedWriter.write("se ha invocado ls");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

            case ":cd" -> {
                bufferedWriter.write("se ha invocado cd");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            case ":q" -> {
                bufferedWriter.write(":q");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            default -> {
                bufferedWriter.write("introduzca comando válido");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

    }
}

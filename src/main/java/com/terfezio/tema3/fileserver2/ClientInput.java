package com.terfezio.tema3.fileserver2;

import java.io.*;

public class ClientInput extends Thread{
    private final BufferedWriter bufferedWriter;
    public ClientInput(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }
    public void run() {


        try(BufferedReader kb = new BufferedReader(new InputStreamReader(System.in))) {

            String prompt = ">>";
            System.out.print(prompt);
            String command = kb.readLine();
            while (!command.equals(":q")) {
                bufferedWriter.write(command);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                System.out.print(prompt);
                command = kb.readLine();

                if(command.equals(":q")) {
                    bufferedWriter.write(":q");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

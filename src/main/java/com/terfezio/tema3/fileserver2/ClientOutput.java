package com.terfezio.tema3.fileserver2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;

public class ClientOutput extends Thread{
    private BufferedReader bufferedReader;
    public ClientOutput(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
    public void run() {

        try {
            //String receivedText = bufferedReader.readLine();
            String receivedText = "";
            while ((receivedText = bufferedReader.readLine()) != null) {
                System.out.println(receivedText);
                //receivedText = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

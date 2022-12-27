package com.terfezio.tema3.udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UdpServer {
    private static final int PORT = 6000;
    public static void main(String[] args) {
       try (DatagramSocket datagramSocket = new DatagramSocket(PORT)){
           System.out.println("(Server): listening");
           
           String message = "";
           byte[] readingBuffer;
           DatagramPacket datagramPacket; 
           while(!message.equals("END")) {
               readingBuffer = new byte[64];
               datagramPacket = new DatagramPacket(readingBuffer, readingBuffer.length);
               datagramSocket.receive(datagramPacket);
               byte[] data = new byte[datagramPacket.getLength()];
               System.arraycopy(datagramPacket.getData(), datagramPacket.getOffset(), data, 0, datagramPacket.getLength());
               message = new String(data);
               writeToFile(message + "\n");
               //System.out.println(message);
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    private static void writeToFile(String message) throws IOException {
        Path path = Paths.get("src/main/java/com/terfezio/tema3/udpserver/data.txt");
        if (!Files.exists(path)) {

            Files.createFile(path);

        }
        Files.write(path, message.getBytes(), StandardOpenOption.APPEND);
    }
}

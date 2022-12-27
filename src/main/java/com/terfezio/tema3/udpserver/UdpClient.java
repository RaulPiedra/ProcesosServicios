package com.terfezio.tema3.udpserver;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    private static final int PORT = 6000;
    public static void main(String[] args) throws UnknownHostException {
        InetAddress serverHost = InetAddress.getLocalHost();
        try(DatagramSocket datagramSocket = new DatagramSocket()) {
            for (int i = 0; i < 10000; i++) {
                String message = "Message: " + i;
                byte[] writingBuffer = message.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(writingBuffer, writingBuffer.length, serverHost, PORT);
                datagramSocket.send(datagramPacket);
                Thread.sleep(1);
            }
            String end = "END";
            for (int i = 0; i < 10; i++) {
                byte[] endBuffer = end.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(endBuffer, endBuffer.length, serverHost, PORT);
                datagramSocket.send(datagramPacket);
            }

        } catch (IOException e) {
           e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.gyd.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName UdpClientDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/7 13:45
 * @Version 1.0
 */
public class UdpServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket  socket = new DatagramSocket(8088);
        byte[] data = new byte[100];
        DatagramPacket packet = new DatagramPacket(data,0,data.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}

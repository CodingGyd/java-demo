package com.gyd.net;

import java.io.IOException;
import java.net.*;

/**
 * @ClassName UdpClientDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/7 13:45
 * @Version 1.0
 */
public class UdpClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket  socket = new DatagramSocket();
        String str = "你好我是UDP";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,8088);
        socket.send(packet);
        socket.close();
    }
}

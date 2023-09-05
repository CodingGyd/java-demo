package com.gyd.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @ClassName SocketClientDemo
 * @Description Socket客户端
 * @Author guoyading
 * @Date 2023/8/7 9:36
 * @Version 1.0
 */
public class SocketServerDemo{

    private ServerSocket serverSocket;

    SocketServerDemo(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }


    public void start() {
        while(true) {
            try {
                System.out.println("等待客户端连接，本端口号为：" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();//阻塞等待
                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("收到客户端信息："+in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("客户端你好，我是服务端：" + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();
            }catch(SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            new SocketServerDemo(6666).start();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}

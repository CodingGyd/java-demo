package com.gyd.net;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName SocketClientDemo
 * @Description Socket客户端
 * @Author guoyading
 * @Date 2023/8/7 9:36
 * @Version 1.0
 */
public class SocketClientDemo {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",6666);

        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);

        out.writeUTF("你好呀，socket服务端,我是" + client.getLocalSocketAddress());

        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        System.out.println("来自服务端的回应:"+in.readUTF());

    }
}

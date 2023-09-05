package com.gyd.io;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @ClassName PrintStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:59
 * @Version 1.0
 */
public class PrintStreamTest01 {
    public static void main(String[] args) {

        try {
            //1.改变流的输出方向
            PrintStream ps = new PrintStream(new FileOutputStream("D:\\test.txt", true));
            //PrintStream ps = new PrintStream("D:/IO/writer7.txt");//会清空内容
            System.setOut(ps);

            System.out.println("hello world");
            System.out.println("你好世界");
            System.out.println("hi world");

            //标准输出流不需要关闭
            //ps.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

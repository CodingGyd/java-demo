package com.gyd.io;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @ClassName DataInputStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:58
 * @Version 1.0
 */
public class DataInputStreamTest01 {
    public static void main(String[] args) {
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(new FileInputStream("D:\\test.txt"));
            System.out.println(dis.readByte());
            System.out.println(dis.readShort());
            System.out.println(dis.readInt());
            System.out.println(dis.readLong());
            System.out.println(dis.readFloat());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readChar());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

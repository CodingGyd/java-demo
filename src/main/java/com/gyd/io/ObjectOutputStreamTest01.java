package com.gyd.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName ObjectOutputStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 16:05
 * @Version 1.0
 */
public class ObjectOutputStreamTest01 {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\test.txt"));
            MyObject a = new MyObject(18, "a", 150.0F);
            MyObject b = new MyObject(18, "b", 123F);
            oos.writeObject(a);
            oos.writeObject(b);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

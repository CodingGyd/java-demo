package com.gyd.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @ClassName ObjectInputStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 16:06
 * @Version 1.0
 */
public class ObjectInputStreamTest01 {
    public static void main(String[] args) {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\test.txt"));
            Object o = ois.readObject();
            if (o instanceof MyObject){
                MyObject a = (MyObject) o;
                System.out.println(a);
            }
            o = ois.readObject();
            if (o instanceof MyObject){
                MyObject a = (MyObject) o;
                System.out.println(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

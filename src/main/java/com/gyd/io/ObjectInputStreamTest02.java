package com.gyd.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ObjectInputStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 16:06
 * @Version 1.0
 */
public class ObjectInputStreamTest02 {
    public static void main(String[] args) {
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\test.txt"));
            Object o = ois.readObject();
            if (o instanceof List){
                ArrayList list = (ArrayList) o;
                for(int i = 0; i < list.size(); i++){
                    System.out.println(list.get(i));
                }
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

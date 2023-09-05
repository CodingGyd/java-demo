package com.gyd.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ObjectOutputStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 16:05
 * @Version 1.0
 */
public class ObjectOutputStreamTest02 {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("D:\\test.txt"));
            List<MyObject> list = new ArrayList<>();
            list.add(new MyObject(18, "a", 190));
            list.add(new MyObject(18, "b", 155));
            list.add(new MyObject(18, "c", 132));
            list.add(new MyObject(18, "d", 112));

            oos.writeObject(list);
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

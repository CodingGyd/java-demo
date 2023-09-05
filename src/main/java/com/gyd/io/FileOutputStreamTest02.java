package com.gyd.io;

import java.io.FileOutputStream;

/**
 * @ClassName FileOutputStreamTest02
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:38
 * @Version 1.0
 */
public class FileOutputStreamTest02 {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("D:\\write2.txt", true);

            byte[] b = {97, 98, 99 , 100};
            fos.write(b, 2, 1);
            String s = "你好你好，大家好";
            byte[] bytes = s.getBytes();
            fos.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.gyd.io;

import java.io.FileInputStream;

/**
 * @ClassName FileInputStreamTest02
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:27
 * @Version 1.0
 */
public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("D:\\test.txt");
            byte[] b = new byte[fis.available()];//不适合大数据量，因为内存中很难找到一块连续的空间
            fis.read(b);//一次读完
            System.out.println(new String(b));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

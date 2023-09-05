package com.gyd.io;

import java.io.FileInputStream;

/**
 * @ClassName FileInputStreamTest02
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:27
 * @Version 1.0
 */
public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("D:\\test.txt");
            byte[] b = new byte[30];//读中文时，数据需开大一点，否则会乱码（一个汉字等于两字节）
            int readCount = 0;

            while((readCount = fis.read(b)) != -1){
                System.out.println(new String(b, 0, readCount));
            }
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

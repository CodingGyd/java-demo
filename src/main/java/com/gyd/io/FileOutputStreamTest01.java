package com.gyd.io;

import java.io.FileOutputStream;

/**
 * @ClassName FileOutputStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:35
 * @Version 1.0
 */
public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("D:\\write1.txt");//没有文件会自动创建，每次自动清空文件内容，慎用！！！

            fos.write(65);
            fos.write(66);
            fos.write(67);
            fos.write(68);
            byte[] b = {97, 98, 99 , 100};
            fos.write(b);
            fos.write(b, 1, 2);
            fos.flush();
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

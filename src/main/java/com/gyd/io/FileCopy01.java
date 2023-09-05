package com.gyd.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @ClassName FileCopy01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:41
 * @Version 1.0
 */
public class FileCopy01 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("D:\\write2.txt");
            fos = new FileOutputStream("D:\\write2-copy.txt");
            byte[] b = new byte[1024 * 1024];//1MB
            int readCount = 0;

            //一边读一边写
            while ((readCount = fis.read(b)) != -1){
                fos.write(b, 0 , readCount);
            }
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

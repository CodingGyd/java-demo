package com.gyd.io;

import java.io.FileInputStream;

/**
 * @ClassName FileInputStreamTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:24
 * @Version 1.0
 */
class FileInputStreamTest01{
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:\\test.txt");
            int res = fis.read();//读到返回该字符ASCII码，没读到返回-1
            System.out.println(res);
            res = fis.read();
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
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
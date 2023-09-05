package com.gyd.io;

import java.io.FileReader;

/**
 * @ClassName FileReaderTest02
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:44
 * @Version 1.0
 */
public class FileReaderTest02 {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("D:\\test.txt");
            char[] c = new char[4];
            int readCount = 0;
            while ((readCount = reader.read(c)) != -1){
                System.out.println(new String(c, 0, readCount));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

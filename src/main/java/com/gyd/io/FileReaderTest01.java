package com.gyd.io;

import java.io.FileReader;

/**
 * @ClassName FileReaderTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:43
 * @Version 1.0
 */
public class FileReaderTest01 {

        public static void main(String[] args) {
            FileReader in = null;

            try {
                in = new FileReader("D:\\test.txt");
                int readCount = 0;
                while ((readCount = in.read()) != -1){
                    System.out.print((char)readCount);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}

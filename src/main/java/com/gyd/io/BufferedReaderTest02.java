package com.gyd.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @ClassName BufferedReaderTest02
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:51
 * @Version 1.0
 */
public class BufferedReaderTest02 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("D:\\test.txt"));
            int readCount = 0;
            char[] c = new char[10];//字节数组
            while ((readCount = reader.read(c)) != -1){
                System.out.print(new String(c, 0, readCount));//加ln排版有问题
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
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

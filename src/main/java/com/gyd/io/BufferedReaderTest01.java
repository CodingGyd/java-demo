package com.gyd.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @ClassName BufferedReaderTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:50
 * @Version 1.0
 */
public class BufferedReaderTest01 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            FileReader fr = new FileReader("D:\\test.txt");//节点流
            reader = new BufferedReader(fr);//包装流
            int readCount = 0;
            while ((readCount = reader.read()) != -1){//单个取
                System.out.print((char)readCount);//加ln排版有问题
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

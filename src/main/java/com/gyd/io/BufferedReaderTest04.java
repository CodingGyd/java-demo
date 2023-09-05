package com.gyd.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @ClassName BufferedReaderTest04
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:54
 * @Version 1.0
 */
public class BufferedReaderTest04 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            FileInputStream fis = new FileInputStream("D:\\test.txt");
            InputStreamReader isr = new InputStreamReader(fis);//字节流转字符流
            reader = new BufferedReader(isr);

            String res =  "";
            while((res = reader.readLine()) != null){
                System.out.println(res);//readLine()读不到换行符，需要手动换行
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

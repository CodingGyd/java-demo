package com.gyd.io;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @ClassName FileCopy01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:41
 * @Version 1.0
 */
public class FileCopy02 {
    public static void main(String[] args) {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("D:\\test.txt");
            writer = new FileWriter("D:\\test-new.txt");
            char[] c = new char[1024 * 512];//1MB
            int readCount = 0;
            //边读边写
            while((readCount = reader.read(c)) != -1){
                writer.write(c, 0, readCount);
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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

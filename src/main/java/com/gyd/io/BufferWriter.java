package com.gyd.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @ClassName BufferWriter
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:52
 * @Version 1.0
 */
public class BufferWriter {
    public static void main(String[] args) {
        BufferedWriter writer = null;
        try {
            FileWriter fw = new FileWriter("D:\\test.txt", true);
            writer = new BufferedWriter(fw);
            writer.write(97);
            writer.write("中国人世界第一");
            writer.write(new char[]{'中', '国', '人'});
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

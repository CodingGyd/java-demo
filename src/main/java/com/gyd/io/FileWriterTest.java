package com.gyd.io;

import java.io.FileWriter;

/**
 * @ClassName FileWriterTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:46
 * @Version 1.0
 */
public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter writer = null;

        try {
            writer = new FileWriter("D:\\writer3.txt", true);
            writer.write(87);
            writer.write("你是中国人，中国人很好");
            char[] c = {'\n', '你', '好', '中', '国'};
            writer.write(c);
            writer.write(c, 1, 2);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

package com.gyd.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @ClassName DataOutputStream01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 15:56
 * @Version 1.0
 */
public class DataOutputStream01 {
    public static void main(String[] args) {
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new FileOutputStream("D:\\test.txt", true));
            byte b = 1;
            short s = 2;
            int i = 3;
            long l = 4L;
            float f = 3.99F;
            double d = 3.14;
            boolean flag = true;
            char sex = '男';
            dos.writeByte(b);
            dos.writeShort(s);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeFloat(f);
            dos.writeDouble(d);
            dos.writeBoolean(flag);
            dos.writeChar(sex);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (dos != null) {
                try {
                    dos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

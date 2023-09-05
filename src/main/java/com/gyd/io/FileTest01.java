package com.gyd.io;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FileTest01
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 16:02
 * @Version 1.0
 */
public class FileTest01 {
    public static void main(String[] args) {
        File f1 = new File("D:\\test1");
        if (!f1.exists()){
            try {
                f1.createNewFile();//创建文件
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File f2 = new File("D:\\test2");
        if (!f2.exists()){
            f2.mkdir();//创建文件夹
        }

        File f3 = new File("D:\\a/b/c/d/e/f/g/h/i");
        if (!f3.exists()){
            f3.mkdirs();//创建多重文件夹
        }

        File f5 = new File("D:\\felete");
        f5.delete();

        File f4 = new File("D:\\新建文件夹");
        String s1 = f4.getName();//新建文件夹
        System.out.println(s1);

        String s2 = f4.getParent();
        System.out.println(s2);

        String s3 = f4.getPath();//D:\\新建文件夹
        System.out.println(s3);

        String s4 = f4.getAbsolutePath();//D:\\新建文件夹
        System.out.println(s4);

        File asf = f4.getAbsoluteFile();
        System.out.println(asf.getAbsolutePath());//D:\\新建文件夹

        File pf = f4.getParentFile();
        System.out.println(pf.getAbsolutePath());//D:

        System.out.println(f4.isDirectory());//true

        System.out.println(f4.isFile());//false

        System.out.println(f4.isHidden());//false

        System.out.println(f4.isAbsolute());//true

        File f6 = new File("D:\\test.txt");
        System.out.println(f6.length());//5743字节

        long lastModify = f6.lastModified();//最后修改时间
        Date d = new Date(lastModify);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(d);
        System.out.println(date);//2021-05-03 22:55:06

        File f7 = new File("D:\\a");
        String[] strList = f7.list();
        for (String s : strList){
            System.out.println(s);
        }

        System.out.println("-----------------------------------------");
        File[] fileList = f7.listFiles();
        for (File f : fileList){
            //System.out.println(f.getPath());
            System.out.println(f.getAbsolutePath());
        }
    }
}

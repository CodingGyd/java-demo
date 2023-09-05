package com.gyd;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/9 13:42
 * @Version 1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//应用程序类加载器

        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//扩展类加载器

        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);//启动类加载器

    }
}

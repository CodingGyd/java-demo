package com.gyd.exception;

/**
 * @ClassName ExceptionTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/4 14:59
 * @Version 1.0
 */
public class ExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        try {
            int a = 10/0;
        } catch (Exception e) {
            throw new MyException("我是自定义异常");
        }
    }
}

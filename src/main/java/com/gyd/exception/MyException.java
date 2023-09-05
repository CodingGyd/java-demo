package com.gyd.exception;

/**
 * @ClassName MyException
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/4 15:21
 * @Version 1.0
 */
public class MyException extends RuntimeException{

    MyException(){super();}

    MyException(String message){
        super(message);
    }
}

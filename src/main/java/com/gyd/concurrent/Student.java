package com.gyd.concurrent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Student {
        Integer id;
        String name;

        public synchronized void printA(){
                System.out.println("AAAAAA");
        }

        public synchronized void printB(){
                System.out.println("BBBBB");
        }
}

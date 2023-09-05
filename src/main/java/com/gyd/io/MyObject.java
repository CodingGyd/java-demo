package com.gyd.io;

import java.io.Serializable;
import java.util.Objects;

/**
 * @ClassName MyObject
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/8 16:10
 * @Version 1.0
 */

class MyObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private int age;
    private String name;
    private transient float weight;//不参与序列化，反序列化出来为默认值

    public MyObject() {
    }

    public MyObject(int age, String name, float weight) {
        this.age = age;
        this.name = name;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject that = (MyObject) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }
}

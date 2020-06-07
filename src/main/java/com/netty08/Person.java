package com.netty08;

import java.io.Serializable;

public class Person implements Serializable, Cloneable {
    private String name;
    private int age;
    private String address;
//
//    Person() {
//    }
//
//    Person(String name, int age, String address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

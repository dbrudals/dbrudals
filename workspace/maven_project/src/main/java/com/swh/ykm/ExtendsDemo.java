package com.swh.ykm;

public class ExtendsDemo {
    public static void main(String[] args) { 
        ChildClass child = new ChildClass("2019. 3. 12");
        System.out.println(child.date);
        child.view();
    }
}
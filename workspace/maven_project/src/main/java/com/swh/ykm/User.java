package com.swh.ykm;

public class User {
    private String name;
    private int age;
    private String id;
    
    public User(String name, int age, String id){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getId() {
        return id;
    }
}
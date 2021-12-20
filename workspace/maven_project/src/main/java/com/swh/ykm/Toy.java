package com.swh.ykm;

public class Toy{
    static int MaxSize = 1024;
    int price;
    String name;
    static{
        System.out.println("생성자보다 먼저 호출되요");
    }
    Toy(int price){
        this.price = price;
    }
    Toy(int price, String name){
    	this(price);
        this.name = name;
    }
    Toy getToy(){ 
        return this;
    }
    void play(){
        System.out.println(this.name+"으로 놉니다.");
    }
}
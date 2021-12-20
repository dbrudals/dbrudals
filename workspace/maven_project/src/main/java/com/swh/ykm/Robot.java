package com.swh.ykm;

public class Robot extends Toy{
    String gender;
    Robot(int price, String name){
        super(price, name);
    } 
    void play(){
        super.play();
        System.out.println(name+"를 움직입니다.");
    }
    void play(String personName){
        System.out.println(personName + "이 " +  getToy().price + "원짜리 "+ 
            name+"를 움직입니다.");
    }
    
    public static void main(String[] args){
        Toy toy = new Toy(5, "레고");
        toy.play();
        Dol dol = new Dol(5, "레고");
        dol.play();
        Robot robot = new Robot(10, "로봇");
        robot.play();
        robot.play("돌쌤");
        System.out.println(Toy.MaxSize);
    }
}
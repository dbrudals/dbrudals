package com.swh.nudle;

public class Shin extends Nudle {

    @Override
    public void one() {
        // TODO Auto-generated method stub
        System.out.println("신 one");
    }


    @Override
    public void two() {
        // TODO Auto-generated method stub
        System.out.println("신 two");
    }

    @Override
    public void three() {
        // TODO Auto-generated method stub
        System.out.println("신 three");
    }
    
    
    public static void main(String[] args){
        Shin a = new Shin();
//     	Cooking a = new Shin(); 훨씬 깔쌈(?)
        a.cooking();
    }
}
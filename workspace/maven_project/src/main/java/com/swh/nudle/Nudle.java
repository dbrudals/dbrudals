package com.swh.nudle;

public abstract class Nudle implements Cooking{

    public abstract void one();
    public abstract void two();
    public abstract void three();
    
    public void cooking() {
        // TODO Auto-generated method stub
        System.out.println("요리되거라");
        one();
        two();
        three();
    }
    
    public void boil() {
        // TODO Auto-generated method stub
        System.out.println("끓어올라라!");
    }
}
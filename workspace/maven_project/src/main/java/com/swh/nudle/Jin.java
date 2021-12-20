package com.swh.nudle;

public class Jin extends Nudle {

    @Override
    public void one() {
        // TODO Auto-generated method stub
        System.out.println("진 one");
    }


    @Override
    public void two() {
        // TODO Auto-generated method stub
        System.out.println("진 two");
    }

    @Override
    public void three() {
        // TODO Auto-generated method stub
        System.out.println("진 three");
    }
    
    
    public static void main(String[] args){
        Jin a = new Jin();
        a.cooking();
    }
}
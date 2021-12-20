package com.swh.nudle;

public class Samyang extends Nudle {

    @Override
    public void one() {
        // TODO Auto-generated method stub
        System.out.println("샴양 one");
    }


    @Override
    public void two() {
        // TODO Auto-generated method stub
        System.out.println("샴양 two");
    }

    @Override
    public void three() {
        // TODO Auto-generated method stub
        System.out.println("샴양 three");
    }
    
    
    public static void main(String[] args){
        Samyang a = new Samyang();
        a.cooking();
    }
}
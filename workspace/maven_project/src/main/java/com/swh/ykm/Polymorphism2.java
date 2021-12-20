package com.swh.ykm;

abstract class AA{
    public abstract void x();
    public void b(){
    }
}
class BB extends AA{
    public void y(){
        System.out.println("자식 y");
    }
    @Override
    public void x() {
        // TODO Auto-generated method stub
    	System.out.println("B");
    }
}
class CC extends AA{
    public void y(){
        System.out.println("자식 y");
    }
    @Override
    public void x() {
        // TODO Auto-generated method stub
    	System.out.println("C");
    }
}
public class Polymorphism2 {
    public void play(AA k){
        k.x();
    }
    public void play(AA[] k){
        for(AA a : k){
            a.x();
        }
    }
    public static void main(String[] args){
//      AA a1 = new AA(); 추상은 new X
        BB a2 = new BB();
        CC a3 = new CC();
        
        AA[] list = new AA[2];
        list[0] = new BB();
        list[1] = new CC();
        
        Polymorphism2 p = new Polymorphism2();
        p.play(a2);
        p.play(a3);
        p.play(list);
    }
}
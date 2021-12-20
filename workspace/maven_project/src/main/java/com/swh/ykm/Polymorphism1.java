package com.swh.ykm;

class A{
    public void x(){
        System.out.println("부모 x");
    }
}
class B extends A{
    public void x(){
        System.out.println("자식 x");
    }
    public void y(){
        System.out.println("자식 y");
    }
}
public class Polymorphism1 {
    public static void main(String[] args	){
        A b = new B();
        b.x();
    }
}
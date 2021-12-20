package com.swh.ykm;

public class CallByReference {
    
    public static void main(String[] args) { 
        Reference a = new Reference(5);
        Reference b = a;
//      System.out.println(System.identityHashCode(a));
//      System.out.println(System.identityHashCode(b));
        a.add(1);
        System.out.println(a.a);
        System.out.println(b.a);
    }
}

class Reference{
    public Integer a;
    public Reference(int value){
        this.a = new Integer(value);
    }
    public void add(Integer value){
        a = a + value;
    }
}
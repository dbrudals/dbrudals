package com.swh.ykm;

public class ReferenceToEquals {
    public static void main(String[] args) {
        String a = "TEST";
        String b = "TEST";
        String c = new String("TEST");
        String d = new String("TEST");
        System.out.println("1:"+a.hashCode());
        System.out.println("2:"+b.hashCode());
        System.out.println("3:"+c.hashCode());
        System.out.println("4:"+d.hashCode());

        System.out.println("5:"+System.identityHashCode(a));
        System.out.println("6:"+System.identityHashCode(b));
        System.out.println("7:"+System.identityHashCode(c));
        System.out.println("8:"+System.identityHashCode(d));

        System.out.println("9:"+(a == b));
        System.out.println("10:"+a.equals(b));
        System.out.println("11:"+(c == d));
        System.out.println("12:"+c.equals(d));
        System.out.println("12-1:"+b.equals(d));

        System.out.println("a.toString():"+a.toString());
        System.out.println("b.toString():"+b.toString());
        System.out.println("c.toString():"+c.toString());
        System.out.println("d.toString():"+d.toString());
    }
}
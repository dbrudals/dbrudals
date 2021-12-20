package com.swh.collection;

import java.util.*;
public class ArrayListVectorTest {
    public static void main(String[] args) {
        Vector<String> v = new Vector<String>(); // 생성자 중에 담을 리스트의 크기를 지정할 수도 있다.
        v.addElement("SWH");            // 리스트 크기가 가득찼어도 추가할 수 있다.
        v.add("Academy");           // 리스트에 추가할 수 있다.
//      v.add(1);    // 오류

        for (String s : v) {
            System.out.println(s);
        }
        
        List<String> a = new ArrayList<String>(); // 생성자 중에 담을 리스트의 크기를 지정할 수도 있다.
        a.add("SWH");               //  리스트에 추가할 수 있다.
        a.add("Academy");       
        for (String s : a) {
            System.out.println(s);
        }
    }
}
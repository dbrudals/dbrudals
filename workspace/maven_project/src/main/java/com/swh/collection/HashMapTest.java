package com.swh.collection;

import java.util.*;
public class HashMapTest {
    public static void main(String args[]) {
        Map<Integer, String> s = new HashMap<Integer, String>();
        s.put(1, "홍길동");
        s.put(2, "김철수");
        s.put(3, "김영희");
        if(s.containsKey(3)){
            System.out.println(s.get(3));
        }
        int index=0;
        while(!s.isEmpty()){
            String value = s.remove(++index);
            System.out.println(value);
        }
    }   
}
package com.swh.collection;

import java.util.*;
public class LinkedListTest {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("SWH");
        list.add("Academy");
        list.add("자바수업 돌쌤입니다.");        
        Iterator<String> it = list.listIterator();
        while(it.hasNext()) {
            String o = it.next();
            System.out.println(o);
        }
        list.remove("Academy");
        while(!list.isEmpty()) {
            String o = list.poll();
            System.out.println(o);
        }
    }
}
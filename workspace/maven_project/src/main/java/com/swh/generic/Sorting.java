package com.swh.generic;

public class Sorting {
    
	/**
     *  Integer, Double, String 등의 클래스는 기본적으로  'Comparable'인터페이스를 구현
     *  'Comparable'인터페이스의 compareTo메소드를 통해 크기를 비교할 수 있다.
     * */
    public static <E extends Comparable<E>> void sort(E[] a) {
        for(int i=0; i < a.length; i++) {
            for(int j=0; j < i; j++) {
                if(a[j].compareTo(a[i]) > 0) {      //  a[j] - a[i] 가 0보다 크면 뒤의 값이 앞의 값보다 큰 것이므로 교환
                    swap(a, i, j);
                }
            }
        }
    }
    
    /**
     *  숫자, 문자 또는 클래스의 객체까지 교환할 때 주로 이런 형태이므로 잘 기억해두자.
     * */
    public static <E> void swap(E[] a, int i, int j) {
        E c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
    
    public static void main(String[] args) {
        String str[] = {"swhAcademy", "SwhAcademy", "하마쌤", "돌쌤"};
        Sorting.sort(str);
        for(int i=0; i < str.length; i++) {
            System.out.print(str[i] +"\t");
        }
        System.out.println();
        Integer num[] = {4, 9, 5, 2, 8, 14, 10};
        Sorting.sort(num);
        for(int i=0; i < num.length; i++) {
            System.out.print(num[i] +"\t");
        }
    }
}

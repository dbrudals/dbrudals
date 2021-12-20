package com.swh.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<Number> s = new HashSet<Number>();
		s.add(new Integer(3));
		s.add(new Integer(3));
		s.add(new Integer(9));
		Iterator<Number> it = s.iterator();
		while(it.hasNext()){
			Number n = it.next();
			System.out.println(n);
		}
	}
}

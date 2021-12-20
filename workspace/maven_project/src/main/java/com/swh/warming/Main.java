package com.swh.warming;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 12; i++) {
			a.add(random.nextInt(5)+1);
		}
		B b = new B(a);
		System.out.println(b.x(b.t()));
		
	}
}

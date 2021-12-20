package com.swh.warming;

import java.util.*;

public class A {
	private List<Integer> a;
	
	public A(List<Integer> b){
		this.a = b;
	}
	public HashMap<Integer, Integer> count(){
		HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
		if(!a.isEmpty()){
			Collections.sort(this.a);
			int last = 0;
			for (int i = Collections.min(a); i<Collections.max(a)+1; i++){
				int e = a.lastIndexOf(i)+1;
				s.put(i, e-last);
				last = e;
			}
		}
		return s;
	}
	public double x(HashMap<Integer, Integer> a){
		int max = Collections.max(a.values());
		int min = Collections.min(a.values());
		return max / min;
	}
}

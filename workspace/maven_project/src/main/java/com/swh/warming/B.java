package com.swh.warming;

import java.util.*;

public class B {
	private List<Integer> a;
	public B(List<Integer> a){
		this.setA(a);
	}
	public List<Integer> getA() {
		return a;
	}
	public void setA(List<Integer> a) {
		this.a = a;
	}

	public Map<Integer, Integer> t(){
		Map<Integer, Integer> b = new HashMap<Integer, Integer>();
		for (int i=1; i<Collections.max(this.a)+1; i++){
			if(this.a.contains(i)){
				b.put(i, this.count(i));
			}
		}
		return b;
	}

	public int count(int value){
		int count = 0;
		for (int i : this.a){
			if(i==value) count+=1;
		}
		return count;
	}

	public double x(Map<Integer, Integer> a){
		double max = Collections.max(a.values());
		double min = Collections.min(a.values());
		return max / min;
	}


}

/*
if(b.containsKey(c)){
	b.put(c, this.count(c));
}
else b.put(c, 1);
 */
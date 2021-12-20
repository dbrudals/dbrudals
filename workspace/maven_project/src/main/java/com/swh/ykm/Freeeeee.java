package com.swh.ykm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Freeeeee {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		String[] b = br.readLine().split(" ");
		int n = Integer.parseInt(a[0]);
		int c = Integer.parseInt(a[1]);
		int count = 0;
		
		for(String s : b){
			int q = Integer.parseInt(s);
			if (q<=c){
				count+=1;
			}
			else if (q>c){
				count = 0;
			}
		}
		System.out.println(count);
	}
}
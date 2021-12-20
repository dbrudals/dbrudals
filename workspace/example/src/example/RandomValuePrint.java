package example;

import java.util.Random;

public class RandomValuePrint {
	public static void main(String[] args) { 
		int[] intValue = new int[10];
		Random random = new Random();
		int index;
		for(index=0; index<10; index++){
			intValue[index] = Math.abs(random.nextInt());
		}
		while(index > 0){
			System.out.println(intValue[--index]);
		}
	}
}

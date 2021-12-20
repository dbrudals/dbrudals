package example;

import java.util.Scanner;

public class Homework {
	public static String convertCase(String c){
		// A~Z = 65~90
		// a~z = 97~122
		char[] a = c.toCharArray();
		for (int i = 0; i<a.length; i++){
			if (a[i]>=65 && a[i]<=90){
				a[i]=(char) (a[i]+32);
			}
			else if (a[i]>=97 && a[i] <= 122){
				a[i]=(char) (a[i]-32);
			}
		}
		return new String(a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("문자열을 입력하세요 :");
		String c = s.nextLine();
		s.close();
		
		// -------------------
		// Sky Seoul Korea Yeonsei
		System.out.println("대소문자 변환 : " + convertCase(c));
		System.out.println("단어수 출력 : " + c.split(" ").length);

	}

}

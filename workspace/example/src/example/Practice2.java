package example;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.println("입력하세요:");
    	String n = s.next();
    	int c = 0;
    	for(int i = 1; i<n.length(); i=i+2){
			c=c+Integer.valueOf(n.substring(i, i+1));
//			System.out.println(n.substring(i,i+1));
    	}
    	System.out.println(c);
    	s.close();
    }
}
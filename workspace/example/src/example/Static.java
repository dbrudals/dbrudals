package example;

public class Static {
    int instanceValue = 5;  // 인스턴스 변수
    static int globalValue = 9; // 클래스 변수
    void play() {
    	instanceValue = 4;
    	System.out.println("하하");
    }
    static void print(){
        System.out.println(globalValue);
    }
    public static void main(String[] args) { 
        Static.globalValue = 8; // ★객체로 만들지 않는다.★
        globalValue = 8; // 이것도 가능
        print();    // 객체로 만들지 않는다.
//        Static.print(); 도 가능       	
        	
        
    }
}
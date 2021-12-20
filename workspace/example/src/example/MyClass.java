package example;

public class MyClass{ // public 으로 되어있는 class의 이름
	
	//	멤버변수(명사..속성), 인스턴스 변수..
    int radius; // 반지름
    String c;

    void draw(){
        System.out.printf("반지름이 %d인 원을 그립니다.", radius);
        System.out.println(c);
    }
    public static void main(String args[]) {
//         클래스 사용
//         radius값은 0
//         c값은 null
        MyClass c = new MyClass(); // new는 메모리에 자리를 차지하면서 주소를 가르키고 있음
        c.draw();
    }
}

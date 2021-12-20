package example;

public class Static2 {
	static int value;
    static{
        //  난수값의 다른표현. 0.0~1.0사이 값
        value = (int)(Math.random() * 1000);
        System.out.println("static{}수행");
    }
    Static2(){
        System.out.println("생성자 수행");
    }
    void print(){
        System.out.println(value);
    }
    public static void main(String[] args) {
        Static2 s = new Static2();
        s.print();
    }
}

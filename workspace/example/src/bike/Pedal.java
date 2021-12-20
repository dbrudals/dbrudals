package bike;

public class Pedal {
	
	public void push(Wheel wheel) {
		System.out.println("페달을 눌렀습니다");
		wheel.speedUp();
	}
}

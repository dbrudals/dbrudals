package cars;

public class Pedal {
	
	public void push(Engine engine, Wheel wheel) {
		System.out.println("페달을 눌렀습니다");
		engine.powerUp(wheel);
	}
}

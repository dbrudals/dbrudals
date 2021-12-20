package cars;

public class Engine {
	
	public void powerUp(Wheel wheel) {
		System.out.println("엔진이 가동되었습니다");
		wheel.speedUp();
	}
}

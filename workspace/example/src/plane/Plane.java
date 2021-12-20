package plane;

public class Plane {
	
	Engine engine = new Engine();
	Pedal pedal = new Pedal();
	Wheel wheel = new Wheel();
	
	public static void main(String[] args) {
		Plane plane = new Plane();
		plane.pedal.push(plane.wheel);
	}
}

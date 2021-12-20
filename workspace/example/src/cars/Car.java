package cars;

public class Car {
	
	Engine engine = new Engine();
	Pedal pedal = new Pedal();
	Wheel wheel = new Wheel();
	
	public static void main(String[] args) {
		Car car = new Car();
		car.pedal.push(car.engine, car.wheel);	
	}
}

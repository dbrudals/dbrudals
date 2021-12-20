package bike;

public class Bike {

	Pedal pedal = new Pedal();
	Wheel wheel = new Wheel();
//	Wheel[] wheel = new Wheel[2];
	
	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.pedal.push(bike.wheel);
	}
}

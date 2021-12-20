package piano;

public class Play{
	public static void main(String[] args) {
		Key key = new Key();
		Pedal pedal = new Pedal();
		System.out.println(key.press());
		System.out.println(pedal.press());
	}

}
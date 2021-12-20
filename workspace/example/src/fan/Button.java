package fan;

public class Button {
	private boolean power;
	private Wings wings = new Wings();
	private boolean spin = false;
	public boolean isPower() {
		return power;
	}

	public void powerOff(){
		this.power = false;
		System.out.println("멈춰유~~");
	}
	public void low(){
		this.power = true;
		System.out.println("천천히 " + this.wings.spin());
	}
	public void high(){
		this.power = true;
		System.out.println("빠르게 " + this.wings.spin());
	}
	public void spin(){
		if(this.spin == true){
			this.spin = false;
			System.out.println("나 회전 안할래유~");
		}
		else{
			this.spin = true;
			System.out.println("나 회전할래유~");
		}
		
	}
}

package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car Toyato = new Car();
		
		Toyato.iMake = 2014;
		Toyato.sColor = "Black";
		Toyato.sTransmission = "Manual";
		
		Toyato.displayCharacteristics();
		Toyato.accelerate();
		Toyato.brake();
	}

}

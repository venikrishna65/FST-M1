package activities;

public class Car {

	String sColor;
	String sTransmission;
	int iMake;
	int iTyres;
	int iDoors;
	
	Car() {
		iTyres = 4;
		iDoors = 4;
	}
	
	public void displayCharacteristics() {
		System.out.println("Color of the Car is " + sColor);
		System.out.println("Transmission of the Car is " + sTransmission);
		System.out.println("Make of the Car is " + iMake);
		System.out.println("Number of Tyres in the Car is " + iTyres);
		System.out.println("Number of Doors in the Car is " + iDoors);
	}
	
	public void accelerate() {
		System.out.println("Car is moving forward");
	}
	
	public void brake() {
		System.out.println("Car has stopped");
	}
}

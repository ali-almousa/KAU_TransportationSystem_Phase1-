import java.util.ArrayList;

public abstract class Flight {
	
	public String typeOfFilght;
	public int timeOfDeparture;
	public int timeOfArrival;
	
	ArrayList<Student> studentsInTrip = new ArrayList<Student>();
	
	// Setters & Getters

	public abstract int getTimeOfDeparture();
	
	public abstract void setTimeOfDeparture(int timeOfDeparture);
	
	public abstract int getTimeOfArrival();
	
	public abstract void setTimeOfArrival(int timeOfArrival);

	public String getTypeOfFilght() {
		return typeOfFilght;
	}
		
	public abstract void setTypeOfFilght(String typeOfFilght);
	
	public abstract double getDISTANCE_TO_KAU();

	public abstract int getMINUTES_TO_KAU();
	
	public abstract int getFUEL_TO_KAU();
}
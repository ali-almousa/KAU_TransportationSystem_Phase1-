import java.util.ArrayList;

public class RegularFlight extends Flight {
	
	
	
	public static final double DISTANCE_TO_KAU = 18.2;
	public static final int MINUTES_TO_KAU = 30;
	public static final int FUEL_TO_KAU = 10;
	
	public RegularFlight() {
		setTypeOfFilght("Regular Flight");
	}
	
	public ArrayList<Student> getStudentsInTrip() {
		return studentsInTrip;
	}

	public void setStudentsInTrip(ArrayList<Student> studentsInTrip) {
		this.studentsInTrip = studentsInTrip;
	}
	
	
	@Override
	public double getDISTANCE_TO_KAU() {
		return DISTANCE_TO_KAU;
	}
	
	@Override
	public int getMINUTES_TO_KAU() {
		return MINUTES_TO_KAU;
	}
	@Override
	public int getFUEL_TO_KAU() {
		return FUEL_TO_KAU;
	}
	
	@Override
	public int getTimeOfDeparture() {
		return timeOfDeparture;
	}
	@Override
	public void setTimeOfDeparture(int timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}
	@Override
	public int getTimeOfArrival() {
		return timeOfArrival;
	}
	@Override
	public void setTimeOfArrival(int timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}

	
	@Override
	public void setTypeOfFilght(String typeOfFilght) {
		this.typeOfFilght = typeOfFilght; 
	}

}
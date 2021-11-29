import java.util.ArrayList;

public abstract class Flight {
	public static int numFlights;
	public String typeOfFilght;
	public int timeOfDeparture;
	public int timeOfArrival;
	
	ArrayList<Student> studentsInTrip = new ArrayList<Student>();
	
	// Setters & Getters

	public abstract int getTimeOfDeparture();
	
	

	public static int getNumFlights() {
		return numFlights;
	}


	public static void incNumFlights() {
		Flight.numFlights++;
	}


	public abstract void setTimeOfDeparture(int timeOfDeparture);
	
	public abstract int getTimeOfArrival();
	
	public abstract void setTimeOfArrival(int timeOfArrival);

	public String getTypeOfFilght() {
		return typeOfFilght;
	}
		
	public void setTypeOfFilght(String typeOfFilght) {
		this.typeOfFilght = typeOfFilght; 
	};
	
	public abstract double getDISTANCE_TO_KAU();

	public abstract int getMINUTES_TO_KAU();
	
	public abstract int getFUEL_TO_KAU();
	
	public String toString() {
		int numFlight = Flight.getNumFlights();
		String TimeDep = Time.MinutesToTime(this.getTimeOfDeparture());
		String TimeArr = Time.MinutesToTime(this.getTimeOfArrival());
		
		String type = this.getTypeOfFilght();
		int numS = this.studentsInTrip.size();
		boolean isFull = numS==10;
				
				
		int c = 0;
		for(Student S : this.studentsInTrip) {
			if(S.isCatch) c++;
		}
		int misses = numS - c;
//		String perC = 100*((double)(c) / (c+misses)) + "%";
		String perCC = String.format("%.2f", 100*((double)(c) / (c+misses))) + "%";
//		return "Flight: " + " " + numFlight + " " + TimeDep + " " + TimeArr + " " + numS + " " + c  + " " + misses + " " + perCC + " " + isFull + " " + type;
		return "Flight: " + "numFlight: " + numFlight + " " +  "TimeDep: " +TimeDep + " " +
		"TimeArr: " +TimeArr + " " +  "numS: " +numS + " " +
		"catch: " +c  + " " +  "misses: " +misses + " " +
		"perCC: " +perCC + " " +  "isFull: " +isFull + " " +  "type: " +type;

	}
}
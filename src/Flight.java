
public abstract class Flight {
	
	public static final double DISTANCE_TO_KAU = 18.2;
	public static final int MINUTES_TO_KAU = 30;
	public static final int FUEL_TO_KAU = 10;
	
	String typeOfFilght;
	Time timeOfDeparture;
	Time timeOfArrival;
	
	Student[] litsOfStudents;

	// Setters & Getters
	
	public Student[] getLitsOfStudents() {
		return litsOfStudents;
	}

	public void setLitsOfStudents(Student[] litsOfStudents) {
		this.litsOfStudents = litsOfStudents;
	}
	
	public String getTypeOfFilght() {
		return typeOfFilght;
	}
	
	public void setTypeOfFilght(String typeOfFilght) {
		this.typeOfFilght = typeOfFilght;
	}
	
	public Time getTimeOfDeparture() {
		return timeOfDeparture;
	}
	
	public void setTimeOfDeparture(Time timeOfDeparture) {
		this.timeOfDeparture = timeOfDeparture;
	}
	
	public Time getTimeOfArrival() {
		return timeOfArrival;
	}
	
	public void setTimeOfArrival(Time timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
	
	public static double getDISTANCE_TO_KAU() {
		return DISTANCE_TO_KAU;
	}
	
	public static int getMINUTES_TO_KAU() {
		return MINUTES_TO_KAU;
	}
	
	////////////////////////////////
	public void fixTimeOfArrival() {
		timeOfArrival.setMinutesElapsed(timeOfDeparture.getMinutesElapsed() + getMINUTES_TO_KAU());
	}
	
	public void fixTimeOfDeparture(int min) {   // min here represent the clock at that time of generating the flight
		timeOfDeparture.setMinutesElapsed(min); // Example: at 8:30 we generate flight inputing clock = 150
	}
	
	public Student[] generateListOfRandomStudents(int numberOfStudents) {
		Student s = new Student();
		Student[] list = new Student[numberOfStudents];
		for (int i = 0; i < numberOfStudents; i++) {
			list[i] = s.randomStudent();
		}
		return list;
	}
	
}

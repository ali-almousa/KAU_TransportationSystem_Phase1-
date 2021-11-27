
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
	
	public abstract double getDISTANCE_TO_KAU();

	
	public abstract int getMINUTES_TO_KAU();
	
	public abstract int getFUEL_TO_KAU();
	
	
	////////////////////////////////
	public abstract void fixTimeOfArrival(); 
	
	public abstract void fixTimeOfDeparture(int min);
	
	public Student[] generateListOfRandomStudents(int numberOfStudents) { //  ????????????? no need
		Student s = new Student();
		Student[] list = new Student[numberOfStudents];
		for (int i = 0; i < numberOfStudents; i++) {
			list[i] = s.randomStudent();
		}
		return list;
	}
	
}
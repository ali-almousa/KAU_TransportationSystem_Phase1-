import java.util.ArrayList;

public class Bus {
	public int numberTrips;
	public double distanceKm;
	public double fuelConsumption;
	public boolean available;
	public int capacity;
	public int avalAt;
	public int ID;
	
	
	
	public ArrayList<Flight> tripsArray = new ArrayList<>();
	public ArrayList<Student> flightStudents = new ArrayList<>();
	public int campusArrival;
	public int dormDeparture;
	public int scheduledDormDeparture;
	
	
	public Bus(int scheduledDormDeparture, int ID) {
		this.setAvailable(true);
		this.setCapacity(10);
		this.setID(ID);
//		this.setTripsArray(new RegularFlight());
		this.setScheduledDormDeparture(scheduledDormDeparture);
	}
	
	
	public Bus(Flight trip, int capacity) {
		this.setAvailable(true);
		this.setCapacity(capacity);
		this.addTripsArray(trip);
	}
	
	
	public Bus(double distance, int trips, double fuelCon, int capacity) {
		this.setAvailable(true);
		this.setDistanceKm(distance);
		this.setNumberTrips(trips);
		this.setFuelConsumption(fuelCon);
		this.setCapacity(capacity);
	}
	
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setID(int ID) {
		this.ID = ID;
	}


	/**
	 * @return the scheduledDormDeparture
	 */
	public int getScheduledDormDeparture() {
		return scheduledDormDeparture;
	}


	/**
	 * @param scheduledDormDeparture the scheduledDormDeparture to set
	 */
	public void setScheduledDormDeparture(int scheduledDormDeparture) {
		//if scheduledDormDeparture is 10:00pm then set this bus as unavailable  
		if(scheduledDormDeparture >= 960) {
			this.setAvailable(false);
		}
		this.scheduledDormDeparture = scheduledDormDeparture;
	}


	/**
	 * @return the numberTrips
	 */
	public int getNumberTrips() {
		return numberTrips;
	}

	/**
	 * @param numberTrips the numberTrips to set
	 */
	public void setNumberTrips(int numberTrips) {
		this.numberTrips = numberTrips;
	}

	/**
	 * @return the distanceKm
	 */
	public double getDistanceKm() {
		return distanceKm;
	}

	/**
	 * @param distanceKm the distanceKm to set
	 */
	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

	/**
	 * @return the fuelConsumption
	 */
	public double getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * @param fuelConsumption the fuelConsumption to set
	 */
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean aval) {
		this.available = aval;
	}
	
	public void checkAval(int mins) {
		// if there is a time set for available then execute the logic
		if(this.getAvalAt() != 0)
		this.setAvailable(mins >= this.getAvalAt());
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	/**
	 * @return the tripsArray
	 */
	public ArrayList<Flight> getTripsArray() {
		return tripsArray;
	}


	/**
	 * @param tripsArray the tripsArray to set
	 */
	public void addTripsArray( Flight trip) {
		this.tripsArray.add(trip);
		// setting cumulative attributes
//		this.setCapacity(trip.DISTANCE_TO_KAU + this.getCapacity());
		this.setDistanceKm(this.getDistanceKm() + 2 * trip.getDISTANCE_TO_KAU());
		this.setFuelConsumption(trip.getFUEL_TO_KAU() + this.getFuelConsumption());
		this.setNumberTrips(this.getNumberTrips() + 1);
	}


	/**
	 * @return the campusArrival
	 */
	// will return the time the bus will arrive to the campus in mins form
	public int getCampusArrival() {
		return campusArrival;
	}


	/**
	 * @param campusArrival the campusArrival to set
	 */
	public void setCampusArrival(int mins) {
		this.campusArrival = mins;
	}


	/**
	 * @return the dormDeparture
	 */
	public int getDormDeparture() {
		return dormDeparture;
	}


	/**
	 * @param dormDeparture the dormDeparture to set
	 */
	public void setDormDeparture(int mins) {
		this.dormDeparture = mins;
	}


	/**
	 * @return the flightStudents
	 */
	public ArrayList<Student> getFlightStudents() {
		return flightStudents;
	}


	/**
	 * @param flightStudents the flightStudents to set
	 */
	public void addFlightStudents(Student student) {
		this.flightStudents.add(student);
	}


	public void loadStudent(Student s) {
		this.setCapacity(this.getCapacity() - 1);
		//update the aval
		if (this.getCapacity() == 0) {
			this.setAvailable(false);
		}

//		Flight lastTrip = this.getTripsArray().get(this.getNumberTrips() - 1);
		this.addFlightStudents(s);
		//add student to the array of students in the flight
		//P2: make casting dynamic
//		((RegularFlight)lastTrip).getStudentsInTrip().add(s);
	}
	
	
	/**
	 * @return the avalAt
	 */
	public int getAvalAt() {
		return avalAt;
	}


	/**
	 * @param avalAt the avalAt to set
	 */
	public void setAvalAt(int avalAt) {
		this.avalAt = avalAt;
	}


	public void sendBus(int avalAt, ArrayList<Student> tempStudents) {
//		Flight currentFlight = this.getTripsArray().get(this.getNumberTrips() - 1);
		Flight currentFlight = new RegularFlight();
		this.addTripsArray(currentFlight);
		
		this.setAvailable(false);
		this.setAvalAt(avalAt  + 2*currentFlight.getMINUTES_TO_KAU());
		this.setScheduledDormDeparture(avalAt  + 2*currentFlight.getMINUTES_TO_KAU() + 30);
		this.setDormDeparture(Time.clock); //as the clock will be set to the time the bus was sent in main
		this.setCampusArrival(Time.clock + currentFlight.getMINUTES_TO_KAU());
		this.setCapacity(10);		
		//make students in this trip miss or catch
		
		currentFlight.setTimeOfArrival(this.getCampusArrival());
		currentFlight.setTimeOfDeparture(this.getDormDeparture());
//		int numStudetns = currentFlight.studentsInTrip.size();
		int numStudetns = this.getFlightStudents().size();
		for (int i = 0; i < numStudetns; i++) {
			Student student = this.getFlightStudents().get(i);
			student.setIsCatch(this.getCampusArrival() <= student.getIntendedArrivalTime());
			tempStudents.add(student);
			currentFlight.studentsInTrip.add(student);
		}
		
		System.out.println(currentFlight);
		System.out.println("Bus ID: " + this.ID);
		for(int i = 0; i < numStudetns; i++) {
			System.out.println(currentFlight.studentsInTrip.get(i));
		}
		
		this.getFlightStudents().clear();
		
//		if (Time.clock >= 930) {
//			this.addTripsArray(new RegularFlight());
//		}
		
	}
	
	
	
	public String toString() {
		return "{Bus Moving at: " + this.getScheduledDormDeparture() + "mins}";
	}
	

	
	

}

import java.util.ArrayList;

public class Bus {
	public int numberTrips;
	public double distanceKm;
	public double fuelConsumption;
	public boolean available;
	public int capacity;
	public int avalAt;
	
	
	
	public ArrayList<Flight> tripsArray = new ArrayList<>();
	public int campusArrival;
	public int dormDeparture;
	public int scheduledDormDeparture;
	
	
	public Bus(int scheduledDormDeparture) {
		this.setAvailable(true);
		this.setCapacity(10);
		this.setTripsArray(new RegularFlight());
		this.setScheduledDormDeparture(scheduledDormDeparture);
	}
	
	
	public Bus(Flight trip, int capacity) {
		this.setAvailable(true);
		this.setCapacity(capacity);
		this.setTripsArray(trip);
	}
	
	
	public Bus(double distance, int trips, double fuelCon, int capacity) {
		this.setAvailable(true);
		this.setDistanceKm(distance);
		this.setNumberTrips(trips);
		this.setFuelConsumption(fuelCon);
		this.setCapacity(capacity);
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
	public void setAvailable(boolean available) {
		this.available = available;
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
	public void setTripsArray( Flight trip) {
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


	public void loadStudent(Student s) {
		this.setCapacity(this.getCapacity() - 1);
		//update the aval
		if (this.getCapacity() == 0) {
			this.setAvailable(false);
		}
		
		Flight lastTrip = this.getTripsArray().get(this.getNumberTrips() - 1);
		//add student to the array of students in the flight
		//P2: make casting dynamic
		((RegularFlight)lastTrip).getStudentsInTrip().add(s);
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
		this.setAvailable(false);
		this.setAvalAt(avalAt);
		this.setDormDeparture(Time.clock); //as the clock will be set to the time the bus was sent in main
		this.setCampusArrival(Time.clock + this.getTripsArray().get(this.getNumberTrips() - 1).getMINUTES_TO_KAU());
		//make students in this trip miss or catch
		int numStudetns = this.getTripsArray().get(this.getNumberTrips() - 1).studentsInTrip.size();
		for (int i = 0; i < numStudetns; i++) {
			Student student = this.getTripsArray().get(this.getNumberTrips() - 1).studentsInTrip.get(i);
			student.setIsCatch(this.getCampusArrival() < student.getIntendedArrivalTime());
			tempStudents.add(student);
		}
		
	}
	
	public String toString() {
		return "{Bus Moving at: " + this.getScheduledDormDeparture() + "mins}";
	}
	

	
	

}

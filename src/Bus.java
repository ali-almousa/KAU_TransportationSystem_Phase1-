import java.util.ArrayList;

public class Bus {
	public int numberTrips;
	public double distanceKm;
	public double fuelConsumption;
	public boolean available;
	public int capacity;
	
	
	public ArrayList<Flight> tripsArray;
	public Time campusArrival;
	public Time dormDeparture;
	
	
	public Bus() {
		this.setAvailable(true);
		this.setCapacity(10);
		this.setTripsArray(new RegularFlight());
	}
	
	
	public Bus(int capacity) {
		this.setAvailable(true);
		this.setCapacity(capacity);
		this.setTripsArray(new RegularFlight());
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
		// tell Ahmed to create specific DISTANCE_TO_KAU and FUEL_TO_KAU 
		// for each child of Flight class as it should be different 
		this.setCapacity(trip.DISTANCE_TO_KAU + this.getCapacity());
		this.setFuelConsumption(trip.FUEL_TO_KAU + this.getFuelConsumption());
		this.setNumberTrips(this.getNumberTrips() + 1);
	}


	/**
	 * @return the campusArrival
	 */
	public Time getCampusArrival() {
		return campusArrival;
	}


	/**
	 * @param campusArrival the campusArrival to set
	 */
	public void setCampusArrival(Time campusArrival) {
		this.campusArrival = campusArrival;
	}


	/**
	 * @return the dormDeparture
	 */
	public Time getDormDeparture() {
		return dormDeparture;
	}


	/**
	 * @param dormDeparture the dormDeparture to set
	 */
	public void setDormDeparture(Time dormDeparture) {
		this.dormDeparture = dormDeparture;
	}


	public void loadStudent(Student s) {
		this.setCapacity(this.getCapacity() - 1);
		//add student to the array of students in the flight
		this.getTripsArray()[this.getNumberTrips() - 1].add(s);
	}
	
	
	public void sendBus() {
		this.setAvailable(false);
		this.dormDeparture.setMinutesElapsed(Time.clock); //as the clock will be set to the time the bus was sent in main
		this.campusArrival.setMinutesElapsed(Time.clock + 30);
		
	}
	
	

}

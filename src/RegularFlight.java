public class RegularFlight extends Flight {
	
	
	
	public static final double DISTANCE_TO_KAU = 18.2;
	public static final int MINUTES_TO_KAU = 30;
	public static final int FUEL_TO_KAU = 10;
	
	public Time timeOfDeparture;
	public Time timeOfArrival;
	
	public RegularFlight(int clock) {
		timeOfDeparture.setMinutesElapsed(clock);
	    timeOfArrival.setMinutesElapsed(timeOfDeparture.getMinutesElapsed() + getMINUTES_TO_KAU());
		
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
	public void fixTimeOfArrival() {
		timeOfArrival.setMinutesElapsed(timeOfDeparture.getMinutesElapsed() + getMINUTES_TO_KAU());
	}
	@Override
	public void fixTimeOfDeparture(int min) {   // min here represent the clock at that time of generating the flight
		timeOfDeparture.setMinutesElapsed(min); // Example: at 8:30 we generate flight inputing clock = 150
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

}

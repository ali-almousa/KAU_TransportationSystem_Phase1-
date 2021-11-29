// convention: everything is in minutes with 6:00Am as
// the starting reference an 10:00Pm as the last reference
public class Time {
	public static int clock;
	public int minutesElapsed;
	public int startingHour;
	public int endingHour;
	
	
	public Time() {
		this.setMinutesElapsed(0);
		this.setStartingHour(0);
		this.setEndingHour(960);
		Time.clock = this.getStartingHour();
	}
	
	public Time(int mins) {
		this.setMinutesElapsed(mins);
		this.setStartingHour(6);
		this.setEndingHour(22);
		Time.clock = this.getStartingHour();
	}
	
	public Time(int mins, int startH, int endH) {
		this.setMinutesElapsed(mins);
		this.setStartingHour(startH);
		this.setEndingHour(endH);
		Time.clock = this.getStartingHour();
	}

	/**
	 * @return the minutesElapsed
	 */
	public int getMinutesElapsed() {
		return minutesElapsed;
	}

	/**
	 * @param minutesElapsed the minutesElapsed to set
	 */
	public void setMinutesElapsed(int minutesElapsed) {
		this.minutesElapsed = minutesElapsed;
	}

	/**
	 * @return the startingHour
	 */
	public int getStartingHour() {
		return startingHour;
	}

	/**
	 * @param startingHour the startingHour to set
	 */
	public void setStartingHour(int startingHour) {
		this.startingHour = startingHour;
	}

	/**
	 * @return the endingHour
	 */
	public int getEndingHour() {
		return endingHour;
	}

	/**
	 * @param endingHour the endingHour to set
	 */
	public void setEndingHour(int endingHour) {
		this.endingHour = endingHour;
	}
	
	
	public static void incrementClock() {
		Time.clock++;
	}
	
	
	public static void incrementClock(int mins) {
		Time.clock = Time.clock + mins;
	}
	
	
	public void resetTime() {
		this.setMinutesElapsed(0);
		Time.clock = this.getStartingHour();
	}
	
	
	public String MinutesToTime() {
		
		String amPm = "AM";
		int hours = (this.getMinutesElapsed() / 60)  + 6;
		int minutes = this.getMinutesElapsed() % 60;
		if (hours > 12) {
			hours -= 12;
			amPm = amPm.replace('A', 'P');
		}
		String time = String.format("%d:%02d %s", hours, minutes, amPm);
		return time;
	}
		
		
		
		public static String MinutesToTime(int mins) {
			
			String amPm = "AM";
			int hours = (mins / 60)  + 6;
			int minutes = mins % 60;
			if (hours > 12) {
				hours -= 12;
				amPm = amPm.replace('A', 'P');
			}
			
			
		String time = String.format("%d:%02d %s", hours, minutes, amPm);
		return time;
	}
		
		
		//
//		public String timeToMinutes(String time) {
//			
//	}
		
		public static void setClock(int mins) {
			Time.clock = mins;
		}
}

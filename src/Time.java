
public class Time {
	public int minutesElapsed;
	public int startingHour;
	public int endingHour;
	
	
	public Time() {
		this.setMinutesElapsed(0);
		this.setStartingHour(6);
		this.setEndingHour(10);
	}
	
	public Time(int mins) {
		this.setMinutesElapsed(mins);
		this.setStartingHour(6);
		this.setEndingHour(10);
	}
	
	public Time(int mins, int startH, int endH) {
		this.setMinutesElapsed(mins);
		this.setStartingHour(startH);
		this.setEndingHour(endH);
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
	
	
	public void incrementMinutes() {
		this.setMinutesElapsed(this.getMinutesElapsed() + 1);
	}
	
	
	public void incrementMinutes(int value) {
		this.setMinutesElapsed(this.getMinutesElapsed() + value);
	}
	
	
	public void resetTime() {
		this.setMinutesElapsed(0);
	}
	
	
	public String getTime(int mins) {
		
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
}

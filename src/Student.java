
public class Student {
	
	//Variables of student
	int id;
	boolean hasExam;
	boolean catch_miss;
	
	Time lectureTime;
	Time intendedDepartureTime;
	Time showupTime;
	Time actualDepartureTime;
	Time arrivalTime;
	
	//Setters & Getters
	
	// ID
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	//hasExam
	public void setHasExam(boolean HX) {
		this.hasExam = HX;
	}
	
	public boolean getHasExam() {
		return this.hasExam;
	}
	
	//catch_miss
	public void setCatchMiss(boolean CM) {
		this.catch_miss = CM;
	}
		
	public boolean getCatchMiss() {
		return this.catch_miss;
	}
	
	//lectureTime
	public void setLectureTime(Time ob) {
		lectureTime = ob;
	}
	
	public Time getLectureTime() {
		return lectureTime;
	}
	
	//IntendedDepartureTime
	public void setIntendedDepartureTime(Time ob) {
		intendedDepartureTime = ob;
	}
	
	public Time getIntendedDepartureTime() {
		return intendedDepartureTime;
	}
	
	//ShowupTime
	public void setShowupTime(Time ob) {
		showupTime = ob;
	}
	
	public Time getShowupTime() {
		return showupTime;
	}
	
	//ActualDepartureTime
	public void setActualDepartureTime(Time ob) {
		actualDepartureTime = ob;
	}
	
	public Time getActualDepartureTime() {
		return actualDepartureTime;
	}
	
	//ArrivalTime
	public void setArrivalTime(Time ob) {
		arrivalTime = ob;
	}
	
	public Time getArrivalTime() {
		return arrivalTime;
	}
	
	/////////////////////////////////
	public void randomLectureTime() {
		int randomMinutes = (int) (Math.random() * ( 32 - 0 ) + 1) * 30;  //32 is the maximum time can be replaced by input 
		lectureTime.setMinutes(randomMinutes);							  //0 is the minimum time can be replaced by input 
	}																	  
	
	public void randomShowupTime() {
		int randomMinutes = (int) (Math.random() * ( lectureTime.getMinutes() - 60 ) + 1);
	}
	
	public void fixIntendedDepartureTime() {
		intendedDepartureTime.setMinutes( lectureTime.getMinutes() + 30);
	}
	
	public void fixArrivalTime() {
		arrivalTime.setMinutes( actualDepartureTime.getMinutes() + 30);
	}
	
}

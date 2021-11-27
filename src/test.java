
public class test {
	int id;				//
	boolean hasExam;	//
	boolean catch_miss;
	Time lectureTime;	//
	Time intendedDepartureTime;
	Time showupTime;	//
	Time actualDepartureTime;
	Time arrivalTime;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time realClock = new Time();

		test s = new test();
		System.out.print("d");
		
	}
	
	public int randomLectureTime() {
		int randomMinutes = (int) (Math.random() * ( 32 - 0 ) + 1) * 30;  //32 is the maximum time can be replaced by input 
		return randomMinutes;											  //0 is the minimum time can be replaced by input 
	}																	  
	
	public int randomShowupTime() {
		int randomMinutes = (int) (Math.random() * ( lectureTime.getMinutesElapsed() - 60 ) + 1);
		return randomMinutes;
	}
	public test() {
//		this.id = 0000000;
//		this.hasExam = false;
		this.setID( (int) (Math.random() * (1000000) ) + 1000000); // XX XX XX X   // need a small fix
		this.setHasExam(Math.random() < 0.95? false:true);
		showupTime.setMinutesElapsed(randomShowupTime());
		lectureTime.setMinutesElapsed(randomLectureTime());
		
	}
//	public test(int id, boolean hasExam, Time showupTime, Time lectureTime) {
//		this.id = id;
//		this.hasExam = hasExam;
//		this.showupTime = showupTime;
//		this.lectureTime = lectureTime;
//	}
	
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
}

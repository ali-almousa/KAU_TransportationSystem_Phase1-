public class Student implements Comparable<Student>  {
	
	//Variables of student
	int id;				
	boolean hasExam;	
	boolean isCatch;
	int intendedArrivalTime;
	int showupTime;	
	
	//Constructors
	public Student() {
		this.setID(randomID());
		this.setHasExam(randomExamCondition());
		this.setIntendedArrivalTime(randomIntendedArrivalTime());
		this.setShowupTime(randomShowupTime());

	}
	
	
	public Student(int id, boolean hasExam, int IAT, int ST) {
		this.setID(id);
		this.setHasExam(hasExam);
		this.setIntendedArrivalTime(IAT);
		this.setShowupTime(ST);

	}
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
	
	//IsCatch
	public void setIsCatch(boolean isCatch ) {
		this.isCatch = isCatch; 
		
	}
	
	public boolean isCatch() {
		return isCatch;
	}
	//ShowupTime
	public void setShowupTime(int mins) {
		showupTime = mins;
	}
	
	public int getShowupTime() {
		return showupTime;
	}
	
	//IntendedDepartureTime
	public void setIntendedArrivalTime(int mins) {
		intendedArrivalTime = mins;
	}
	
	public int getIntendedArrivalTime() {
		return intendedArrivalTime ;
	}
	
	//-----------------------------															  
	
	public int randomID() {

		int id = (int) (Math.random() * (1000000) ) + 1000000;
		return id;
	}
	
	public boolean randomExamCondition() {
		boolean Exam = Math.random() < 0.95? false:true;
		return Exam;
	}
	
	public int randomShowupTime() {
		int randomMinutes =  getIntendedArrivalTime() - 60 + (int) (Math.random() * 30) ;
		return randomMinutes;
	}
	
	public int randomIntendedArrivalTime() {
		  int randomTime = (int) (Math.random() * ( 32 ) + 1) * 30;
		  if (randomTime == 960) {
			  return randomTime;
		  } else if (randomTime < 60) {
			  return randomTime + 60;
		  }else 
			  return randomTime;
	}

	@Override
	public int compareTo(Student comparestu)
    {
        int compareShowUpTime = ((Student)comparestu).getShowupTime();
        //  For Ascending order
        return this.showupTime - compareShowUpTime;

    }


	// From this line is just for testing you can delete it-------------
	@Override
	public String toString() {
//		return "Student ["id=" + id + ",      hasExam=" + hasExam + ",    intendedArrivalTime=" + getTime(intendedArrivalTime) + ",      showupTime=" + getTime(showupTime) + "]";
		int ID = this.getID();
		boolean hasE = this.getHasExam();
		String ST = Time.MinutesToTime(this.getShowupTime());
		String IAT =  Time.MinutesToTime(this.getIntendedArrivalTime());
		boolean c = this.isCatch;
		
		return  "ID: " + ID + " " +  "hasE: " + hasE + " " +  "ST: " + 
		ST + " " +  "IAT: " + IAT + " " +  "catch: " + c;
		

	}

	public static String getTime(int mins) {
			
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
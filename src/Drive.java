import java.util.ArrayList;
import java.util.Scanner;

public class Drive {

	public static void main(String[] args) {
        // create time object
		Time realClock = new Time();
		
		
        //initilize required number of days varaible
		Scanner input = new Scanner(System.in);
		int testDays = input.nextInt();
		
			

        //create an ordered array of random students based on showed up times
		int testStudents = input.nextInt();
		ArrayList<Student> students = null;
		for(int i = 0; i < testStudents; i++) {
			// tell Ahmed to make randomStudent() and all 
			// methods it calls static	
			students.add(new Student());
		}
		
		
		
        //create an array of busses
		int testBusses = input.nextInt();
		ArrayList<Bus> busses = null;
		for(int i = 0; i < testBusses; i++) {
			// tell Ahmed to make randomStudent() and all 
			// methods it calls static
			busses.add(new Bus());
		}
		
		
		
		
        //initillize main while loop (number of days)
		while(testDays > 0) {

            //inner while loop (default 16 hours)
			int testHours = realClock.endingHour - realClock.startingHour;
			while(testHours > 0) {

		        // generate a flight according to clock
				Flight flightType = new regularFlight();
                //check the student: showed up = clock
				
                    // if yes: load to bus and incerement student pointer
                    // if no: increment the clock and continue from loading students loop
                //check capacity
                // if full:
                    // 1- send the bus (change availability to false)
                    // 2- update data of the busses
                        // - time of arrival
                        // - time of departure
                        // - distance covered
                        // - fuel consumption
                        // - add trip to trips array
                    // 3- increment the bus pointer of the array
                    // 4- update the clock to the next bus departure time (jump forward) 
                    // 5- continue loading students with updated clock
                // else contnuie if there are any students
		
			}
		}
		
		
		
		
		
	}

}
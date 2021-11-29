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
			students.add(new Student());
		}
		
		
		
        //create a Queue of busses
		int testBusses = input.nextInt();
//		ArrayList<Bus> busses = null;
		Queue busses = new Queue(testBusses);
		int scheduledDormDeparture;
		for(int i = 0; i < testBusses; i++) {
			//formula for cal the schduled dorm departure
			scheduledDormDeparture = 30*i + 30;
			busses.enqueue(new Bus(scheduledDormDeparture));
//			busses.add(new Bus(scheduledDormDeparture));
		}
		
		
		
		
        //initillize main while loop (number of days)
		while(testDays > 0) {
			//create a temp array of arrived students
            //inner while loop (default 16 hours)
			int testHours = realClock.endingHour - realClock.startingHour;
			

	        // generate a flight according to clock
			Flight flightType = new RegularFlight(realClock.clock);
			
			//create pointers(bus and student)
			int studentPointer = 0;
			int busPointer = 0;
			
			//while loop on the array of students
			while (students.size() != 0) {
				//current bus
				Bus bus = busses.get(busPointer);
				//current student
				Student student = students.get(studentPointer);
				//current trip
				Flight trip = bus.getTripsArray(bus.getNumberTrips() - 1);
				
				
				
				// if clock >= realClock.endingHour
				if (realClock.clock >= realClock.endingHour) {
					//break
					break;
				}
			
                //else if showed up = clock
				else if (students.get(studentPointer).getShowupTime().getMinutesElapsed() == Time.clock) {
					/// {check that capacity != -1}
                    //load to bus and incerement student pointer
					busses.get(busPointer).loadStudent(students.get(studentPointer));
					studentPointer++;
					
				}
			
                //else if showed up < clock
				else if (students.get(studentPointer).getShowupTime().getMinutesElapsed() < Time.clock) {
					
					//if arrival time of the this bus is > the intended time of S
					if (busses.get(busPointer).getCampusArrival() > students.get(studentPointer).getIntendedDepartureTime()) {
						//load to bus + increment pointer student
						busses.get(busPointer).loadStudent(students.get(studentPointer));
						studentPointer++;
					}
				
				
					//else
					else {
						//load
						busses.get(busPointer).loadStudent(students.get(studentPointer));
						studentPointer++;
						// we didn't increment student pointer WHY? 
						
					}
				}
			

                // else:
				else {
					//increment the clock                     
					Time.incrementClock();
				}
			
			
				//update availability check availability
				for(int i = 0; i < testBusses; i++) {
					//formula for cal the schduled dorm departure
					scheduledDormDeparture = 30*i + 30;
					busses.enqueue(new Bus(scheduledDormDeparture));
//					busses.add(new Bus(scheduledDormDeparture));
				}
				bus.setAvailable(bus.avalAt == Time.clock);
				
			
				
				// if capacity is full:
				if (bus.getCapacity() == 0) {
                    // 1- send the bus (change availability to false)
					bus.sendBus(Time.clock + 2*trip.getMINUTES_TO_KAU());
                    // 2- update data of the busses
                        // - time of arrival
                        // - time of departure
                        // - distance covered
                        // - fuel consumption
                        // - add trip to trips array
                    // 3- increment the bus pointer of the array
					busPointer++;
                    // 4- update the clock to the current scheduled bus departure time (jump forward)
					Time.setClock(bus.getScheduledDormDeparture());
                    // 5- continue loading students with updated clock
					continue;
        		// else if capacity is not full:
				else if (bus.getCapacity() > 0) {
					// if clock meets (every 30 mins a bus should move regardless of students) && there is at least one student in the bus:
					if (bus.getScheduledDormDeparture() == Time.clock && bus.getTripsArray(bus.getNumberTrips() - 1).studentsInTrip.size() != 0) {
	                // 1- send the bus (change availability to false)
						bus.sendBus(Time.clock + 2*trip.getMINUTES_TO_KAU());
	                // 2- update data of the busses
	                    // - time of arrival
	                    // - time of departure
	                    // - distance covered
	                    // - fuel consumption
	                    // - add trip to trips array
	                // 3- increment the bus pointer of the array
						busPointer++;
	                // 4- update the clock to the next bus departure time (jump forward) 
						Time.setClock(bus.getScheduledDormDeparture());
	                // 5- continue loading students with updated clock
						continue;
				}
				
			
					// else if the student pointer is null && there is at least one student in the bus
					else if (studentPointer >= students.size() && bus.getTripsArray(bus.getNumberTrips() - 1).studentsInTrip.size() > 0) {
						
						//send the bus
						bus.sendBus(Time.clock + 2*trip.getMINUTES_TO_KAU());
					}
			
					}
		}//end students loop
		
		//loop in the array of arrived students and the array of busses and print the report
		//reinitilize the array of students and busses and reset clock
		//reinitilize pointers(bus and student)
		} //end days loop
		
		
		
		
		
	}

}

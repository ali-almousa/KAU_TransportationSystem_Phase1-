import java.util.ArrayList;
import java.util.Collections;
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
		ArrayList<Student> students = new ArrayList<>();
		for(int i = 0; i < testStudents; i++) {
			students.add(new Student());
		}
		Collections.sort(students);
		
		System.out.println("Test students");
		for(Student s: students) {
			System.out.println(s);
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
			ArrayList<Student> tempStudents = new ArrayList<>();
            //inner while loop (default 16 hours)
			int testHours = realClock.endingHour - realClock.startingHour;
			

	        // generate a flight according to clock
//			Flight flightType = new RegularFlight(realClock.clock);
			Flight flightType = new RegularFlight();
			
			//create pointers(bus and student)
			int studentPointer = 0;
			
			//while loop on the array of students
			while (students.size() != 0) {
				//current bus
				Bus bus = busses.peek();
				//current student
				Student student = students.get(studentPointer);
				//current trip
				Flight trip = bus.getTripsArray().get(bus.getNumberTrips() - 1);
				
				
				
				// if clock >= realClock.endingHour
				if (realClock.clock >= realClock.endingHour) {
					//break
					break;
				}
			
                //else if showed up = clock
				else if (student.getShowupTime() == Time.clock) {
					/// {check that capacity != -1}
                    //load to bus and incerement student pointer
					bus.loadStudent(students.get(studentPointer));
					studentPointer++;
					
				}
			
                //else if showed up < clock
				else if (student.getShowupTime() < Time.clock) {
					
					//if arrival time of the this bus is > the intended time of S
					if (bus.getCampusArrival() > student.getIntendedArrivalTime()) {
						//load to bus + increment pointer student
						bus.loadStudent(students.get(studentPointer));
						studentPointer++;
					}
				
				
					//else
					else {
						//load
						bus.loadStudent(students.get(studentPointer));
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
					Bus currentBus = busses.peek();
					currentBus.checkAval(Time.clock);
					busses.dequeue();
					busses.enqueue(currentBus);
					
				}
				
			
				
				// if capacity is full:
				if (bus.getCapacity() == 0) {
                    // 1- send the bus (change availability to false)
					bus.sendBus(Time.clock + 2*trip.getMINUTES_TO_KAU(), tempStudents);
                    // 2- update data of the busses
                        // - time of arrival
                        // - time of departure
                        // - distance covered
                        // - fuel consumption
                        // - add trip to trips array
					
					
					
					
                    // 3- increment the bus pointer of the array
					busses.dequeue();
					busses.enqueue(bus);
					
					
					
					
                    // 4- update the clock to the current scheduled bus departure time (jump forward)
					Time.setClock(bus.getScheduledDormDeparture());
                    // 5- continue loading students with updated clock
					continue;
				}
        		// else if capacity is not full:
				else if (bus.getCapacity() > 0) {
					// if clock meets (every 30 mins a bus should move regardless of students) && there is at least one student in the bus:
					if (bus.getScheduledDormDeparture() == Time.clock && bus.getTripsArray().get(bus.getNumberTrips() - 1).studentsInTrip.size() != 0) {
	                // 1- send the bus (change availability to false)
						bus.sendBus(Time.clock + 2*trip.getMINUTES_TO_KAU(), tempStudents);
	                // 2- update data of the busses
	                    // - time of arrival
	                    // - time of departure
	                    // - distance covered
	                    // - fuel consumption
	                    // - add trip to trips array
						
						
						
						
						
	                // 3- increment the bus pointer of the array
						busses.dequeue();
						busses.enqueue(bus);
						
						
						
						
	                // 4- update the clock to the next bus departure time (jump forward) 
						Time.setClock(bus.getScheduledDormDeparture());
	                // 5- continue loading students with updated clock
						continue;
				}
				
			
					// else if the student pointer is null && there is at least one student in the bus
					else if (studentPointer >= students.size() && bus.getTripsArray().get(bus.getNumberTrips() - 1).studentsInTrip.size() > 0) {
						
						//send the bus
						bus.sendBus(Time.clock + 2*trip.getMINUTES_TO_KAU(), tempStudents);
					}
			
					}
		}//end students loop
		
		//loop in the array of arrived students and print the report
		for(int i = 0; i < tempStudents.size(); i++) {
			Student s = tempStudents.get(i);
			System.out.println(s);
		}
		// loop in the array of busses and print the report
		
		
		//reinitilize the array of students and busses and reset clock
		Time.clock = realClock.getStartingHour();
		tempStudents.removeAll(tempStudents);
		
		//reinitilize pointers(bus and student)
		studentPointer = 0;
		} //end days loop
		
		
		
		
		
	}

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Drive {

	public static void main(String[] args) {
        // create time object
		Time realClock = new Time();
		
		
        //************initilize required number of days varaible************
		Scanner input = new Scanner(System.in);
		System.out.println("Test days: ");
		int testDays = input.nextInt();
		
		

		
		
		//************************STUDENTS*************************
        //create an ordered array of random students based on showed up times
		System.out.println("Number of students: ");
		int testStudents = input.nextInt();
		ArrayList<Student> students = new ArrayList<>();
		
//		for(int i = 0; i < testStudents; i++) {
//			students.add(new Student());
//		}
//		//fixed students2
		students.add(new Student(1946282, false, 960, 900));//1
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));
		students.add(new Student(1946282, false, 960, 900));//10
		students.add(new Student(1946282, false, 960, 901));
//		//fixed students1
//		students.add(new Student(1946282, false, 90, 41));
//		students.add(new Student(1945427, false, 300, 240));
//		students.add(new Student(1945541, false, 330, 282));
//		students.add(new Student(1935944, false, 420, 365));
//		students.add(new Student(1935944, false, 750, 705));
		//OUR TEAM
//		students.add(new Student(1946282, false, 90, 30));
//		students.add(new Student(1945427, false, 60, 1));
//		students.add(new Student(1945541, false, 60, 2));
//		students.add(new Student(1935944, false, 90, 31));
		Collections.sort(students);
		System.out.println("Test students");
		for(Student s: students) {
			System.out.println(s);
		}
		
		
		
		
		
		//************************BUSSES*************************
        //create a Queue of busses
		System.out.println("Number of busses: ");
		int testBusses = input.nextInt();
		Queue busses = new Queue(testBusses);
		int scheduledDormDeparture;
		for(int i = 0; i < testBusses; i++) {
			//formula for cal the schduled dorm departure
			scheduledDormDeparture = 30*i + 30;
			busses.enqueue(new Bus(scheduledDormDeparture, i));
		}
		
		
		
		
		
		
		//********************LOOPS(MAIN TASK)************************
        //initillize main while loop (number of days)
		while(testDays > 0) {
			//create a temp array of arrived students
			ArrayList<Student> tempStudents = new ArrayList<>();

			//create pointer student
			int studentPointer = 0;
			
			//while loop on the array of students
			while (tempStudents.size() < students.size()) {
				
				// if clock >= realClock.endingHour
				if (Time.clock >= realClock.endingHour) break;
				
				//update availability after incrementing the clock
//				updateAval(testBusses, busses);
				//update availability after incrementing the clock
				for(int i = 0; i < testBusses; i++) {
					Bus currentBus = busses.peek();
					currentBus.checkAval(Time.clock);
					busses.dequeue();
					busses.enqueue(currentBus);
				}
				
				//current bus & current student
				Bus bus = busses.peek();
				Student student = students.get(studentPointer);

				//if not aval update the bus pointer to
				// the next bus and continue back
				if (!bus.isAvailable()) {
					busses.dequeue();
					busses.enqueue(bus);
					Time.incrementClock();
					continue;
				}

                //else if showed up = clock
				if (student.getShowupTime() <= Time.clock) {
					/// {check that capacity != -1}
                    //load to bus and increment student pointer
					bus.loadStudent(student);
					studentPointer++;
					
				}
 
				else {
					//increment the clock                     
					Time.incrementClock();
				}
				
				//update availability after incrementing the clock
//				updateAval(testBusses, busses);
				//update availability after incrementing the clock
				for(int i = 0; i < testBusses; i++) {
					Bus currentBus = busses.peek();
					currentBus.checkAval(Time.clock);
					busses.dequeue();
					busses.enqueue(currentBus);
				}

				// if capacity is full:
				if (bus.getCapacity() == 0) {
                    // 1- send the bus (change availability to false)
                    // 2- update data of the busses
                    // - time of arrival
                    // - time of departure
                    // - distance covered
                    // - fuel consumption
                    // - add trip to trips array
					System.out.println();
					bus.sendBus(Time.clock, tempStudents);
                    // 3- increment the bus pointer of the array
					busses.dequeue();
					busses.enqueue(bus);
                    // 4- increment the clock 
					Time.incrementClock();
                    // 5- continue loading students with updated clock
					continue;
				}
				
        		// else if there is at least one student in the bus(cap < 10):
				else if (bus.getCapacity() < 10) {
					// if clock meets (every 30 mins a bus should move regardless of students) && there is at least one student in the bus:
					if (bus.getScheduledDormDeparture() == Time.clock) {
	                // 1- send the bus (change availability to false)
		                // 2- update data of the busses
	                    // - time of arrival
	                    // - time of departure
	                    // - distance covered
	                    // - fuel consumption
	                    // - add trip to trips array
						System.out.println();
						bus.sendBus(Time.clock, tempStudents);
	                // 3- increment the bus pointer of the array
						busses.dequeue();
						busses.enqueue(bus);
                    // 4- increment the clock 
						Time.incrementClock();
	                // 5- continue loading students with updated clock
						continue;
				}
					// else if the student pointer is null && there is at least one student in the bus
					else if (studentPointer >= students.size()) {
						//send the bus
						System.out.println();
						while (true) {
							if (bus.getScheduledDormDeparture() == Time.clock) break;
							Time.incrementClock();	
						}
						bus.sendBus(Time.clock, tempStudents);
						break;
					}
			
					}
				
				// if there are no students in the bus and clock meets scheduled dormDeparture:
				if (bus.getCapacity() == 10 && bus.getScheduledDormDeparture() == Time.clock) {
                    //update the scheduled dormDeparture to the current scheduled bus departure time + 30
					// whish is (period for waiting students)
					for(int i = 1; i <= busses.size(); i++) {
						int NSDD = Time.clock + i*30;
						Bus current = busses.peek();
						current.setScheduledDormDeparture(NSDD);
						busses.dequeue();
						busses.enqueue(current);
					}
//					bus.setScheduledDormDeparture(Time.clock + 30);
                    // 5- continue loading students with updated scheduled dormDeparture
					continue;
				}
		}//end students loop
		
		//loop in the array of arrived students and print the report
		System.out.println("\n\nstudents in the whole day:");
		System.out.println(tempStudents.size());
		for(int i = 0; i < tempStudents.size(); i++) {
			Student s = tempStudents.get(i);
			System.out.println(s);
		}
		//reinitilize the array of students and busses and reset clock
		Time.clock = realClock.getStartingHour();
		tempStudents.clear();
		//reinitilize pointers(bus and student)
		studentPointer = 0;
		//decrement the testDays
		testDays--;
		} //end days loop
		
		
		
		
		
	}
	
	public static void updateAval(int testBusses, Queue busses) {
		//update availability after incrementing the clock
		for(int i = 0; i < testBusses; i++) {
			Bus currentBus = busses.peek();
			currentBus.checkAval(Time.clock);
			busses.dequeue();
			busses.enqueue(currentBus);
		}
	}

}

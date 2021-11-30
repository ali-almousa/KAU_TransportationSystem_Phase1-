
public class testing {

	public static void main(String[] args) {
		Queue busses = new Queue(3);
		int scheduledDormDeparture;
		for(int i = 0; i < 3; i++) {
			scheduledDormDeparture = 30*i + 30;
			busses.enqueue(new Bus(scheduledDormDeparture, i));
		}
		for(int i = 0; i < 3; i++) {
			Bus bus = busses.peek();
//			bus.setAvalAt(1);
			busses.dequeue();
			busses.enqueue(bus);
			
		}
//		Bus bus = busses.peek();
//		bus.setAvalAt(1);
//		busses.dequeue();
//		busses.enqueue(bus);
//		
//		bus = busses.peek();
//		busses.dequeue();
//		busses.enqueue(bus);
//		
//		bus = busses.peek();
//		busses.dequeue();
//		busses.enqueue(bus);

	}

}



public class testing {

	public static void main(String[] args) {
		Queue q = new Queue(3);
		int scheduledDormDeparture;
		for(int i = 0; i < 3; i++) {
			scheduledDormDeparture = 30*i + 30;
			q.enqueue(new Bus(scheduledDormDeparture));
		}
		System.out.println(q);
		Bus bus = q.peek();
		q.dequeue();
		q.enqueue(bus);
		System.out.println(q);
//        System.out.println("The front element is " + q.peek());
//        q.dequeue();
//        System.out.println("The front element is " + q.peek());
// 
//        System.out.println("The queue size is " + q.size());
// 
//        q.dequeue();
//        q.dequeue();
// 
//        if (q.isEmpty()) {
//            System.out.println("The queue is empty");
//        }
//        else {
//            System.out.println("The queue is not empty");
//        }

	}

}


//busses.dequeue();
//busses.enqueue(bus);
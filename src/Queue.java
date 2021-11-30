import java.util.Arrays;

//
class Queue
{
    private Bus[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    private int count;      // current size of the queue
 
    // Constructor to initialize a queue
    Queue(int size)
    {
        arr = new Bus[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    // Utility function to dequeue the front element
    public void dequeue()
    {
        // check for queue underflow
        if (isEmpty())
        {
            System.out.println("Take a taxi ya wahsh!\nDon't forget your Azkar");
            System.exit(1);
        }
 
//        System.out.println("Removing " + arr[front]);
 
        front = (front + 1) % capacity;
        count--;
    }
 
    // Utility function to add an item to the queue
    public void enqueue(Bus item)
    {
        // check for queue overflow
        if (isFull())
        {
            System.out.println("Take a taxi ya wahsh!\nDon't forget your Azkar");
            System.exit(1);
        }
 
//        System.out.println("Inserting " + item);
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    // Utility function to return the front element of the queue
    public Bus peek()
    {
        if (isEmpty())
        {
            System.out.println("Take a taxi ya wahsh!\nDon't forget your Azkar");
            System.exit(1);
        }
        return arr[front];
    }
 
    // Utility function to return the size of the queue
    public int size() {
        return count;
    }
 
    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        return (size() == 0);
    }
 
    // Utility function to check if the queue is full or not
    public Boolean isFull() {
        return (size() == capacity);
    }
    
    public String toString() {
    	String arrString = Arrays.toString(this.arr);
    	return "Queue: "+ arrString;
    }
}











//public class Queue {
//  int SIZE = 5;
//  Bus items[] = new Bus[SIZE];
//  int front, rear;
//
//  Queue() {
//    front = -1;
//    rear = -1;
//  }
//
//  // check if the queue is full
//  boolean isFull() {
//    if (front == 0 && rear == SIZE - 1) {
//      return true;
//    }
//    return false;
//  }
//
//  // check if the queue is empty
//  boolean isEmpty() {
//    if (front == -1)
//      return true;
//    else
//      return false;
//  }
//
//  // insert elements to the queue
//  void enQueue(Bus element) {
//
//    // if queue is full
//    if (isFull()) {
//      System.out.println("Queue is full");
//    }
//    else {
//      if (front == -1) {
//        // mark front denote first element of queue
//        front = 0;
//      }
//
//      rear++;
//      // insert element at the rear
//      items[rear] = element;
//      System.out.println("Insert " + element);
//    }
//  }
//
//  // delete element from the queue
//  Bus deQueue() {
//    Bus element;
//
//    // if queue is empty
//    if (isEmpty()) {
//      System.out.println("Queue is empty");
//      System.exit(1);
//    }
//    else {
//      // remove element from the front of queue
//      element = items[front];
//
//      // if the queue has only one element
//      if (front >= rear) {
//        front = -1;
//        rear = -1;
//      }
//      else {
//        // mark next element as the front
//        front++;
//      }
//      System.out.println( element + " Deleted");
//      return element;
//    
//  }
//  }
//
//  // display element of the queue
//  void display() {
//    int i;
//    if (isEmpty()) {
//      System.out.println("Empty Queue");
//    }
//    else {
//      // display the front of the queue
//      System.out.println("\nFront index-> " + front);
//
//      // display element of the queue
//      System.out.println("Items -> ");
//      for (i = front; i <= rear; i++)
//        System.out.print(items[i] + "  ");
//
//      // display the rear of the queue
//      System.out.println("\nRear index-> " + rear);
//    }
//  }
//  
//}
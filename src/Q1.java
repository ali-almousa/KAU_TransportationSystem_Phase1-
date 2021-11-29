
public class Q1 {

	public static void main(String[] args) {
		int x = 20;
		
		System.out.println("Before the call, x is " + x);
		
		increment(x);
		
		System.out.println("After the call, x is " + x);

	}

	public static void increment(int n) {
		n = n + 1;
		System.out.println("n inside the method is " + n);
	}
}

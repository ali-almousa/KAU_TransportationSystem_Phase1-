import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int NUMBER_OF_DAYS = 7;
		String[] days = new String[NUMBER_OF_DAYS];
		
		System.out.print("Enter days week: ");
		
		for(int i = 1; i <= NUMBER_OF_DAYS; i++) {
			System.out.printf("Enter day number %d in the week: ", i);
			days[i - 1] = input.nextLine();
			 
		}
		
		System.out.println("------------------------");
		System.out.println("The array of days week is:");
		for (String day : days) {
			System.out.println(day);
		}
		

	}

}

import java.util.Scanner;

public class NumberGuessingGame {
	public static final int MaxValues = 14;
	public static final int MaxNum = 9999;
	//main section
	public static void main(String[] args) {
		int randomNumber = randomNumGenerated();
		gameMain(randomNumber);
	}
	
	public static int randomNumGenerated() {
		return (int) (Math.random() * (MaxNum + 1));
	}
	
	public static void gameMain(int randomNumber) {
		Scanner scan = new Scanner(System.in);
		int attempts = 0;
		
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("You only get 14 guesses. Guess a number between 0 and 9999.");
		
		while (attempts < MaxValues) {
			System.out.printf("Attempt #%d: ",attempts+1);
			//Nags user to input integer and integer only
			while (!scan.hasNextInt()) {
				System.out.println("Invalid input. Please enter a valid integer.");
				System.out.print("Attempt #" + (attempts + 1) + ": ");
				scan.next();
			}
			int guessedNum = scan.nextInt();
			
			if (guessedNum == randomNumber) {
				System.out.println("Congratulations! You guessed the number in " + (attempts + 1) + " attempts.");
				return;
			} else if (guessedNum < randomNumber) {
				System.out.println("The number is bigger.");
			} else {
				System.out.println("The number is smaller.");
			}
			attempts++;
		}
		
		System.out.println("Sorry, all of the " + MaxValues + " attempts are gone.");
		System.out.println("The number was: " + randomNumber);
	}
}
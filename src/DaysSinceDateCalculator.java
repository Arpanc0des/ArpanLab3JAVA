import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DaysSinceDateCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a space-separated date (format: MM dd yyyy): ");
		String inputDate = scan.nextLine();
		
		try {
			// user input convert to a LocalDate object using specified format
			LocalDate enteredDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("MM dd yyyy"));
			LocalDate currentDate = LocalDate.now();
			
			long daysSinceDate = calculateDaysBetween(enteredDate, currentDate);
			
			// Display the result
			System.out.printf("It has been %d days since %s", daysSinceDate, inputDate);
		} catch (Exception e) {
			System.out.println("Invalid date format. Please enter a date in the format MM dd yyyy.");
		}
	}
	
	private static long calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
		long days = 0;
		LocalDate tempDate = startDate;
		//counts each day between
		while (tempDate.isBefore(endDate)) {
			tempDate = tempDate.plusDays(1);
			days++;
		}
		
		return days;
	}
}

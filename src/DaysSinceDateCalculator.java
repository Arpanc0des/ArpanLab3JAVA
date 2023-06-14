import java.util.Scanner;
public class DaysSinceDateCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a date (format: MM dd yyyy): ");
		String inputDate = scan.nextLine();
		
		try {
			// Parse the user input into individual date components
			String[] date_MDY_values = inputDate.split(" ");
			int month = Integer.parseInt(date_MDY_values[0]);
			int day = Integer.parseInt(date_MDY_values[1]);
			int year = Integer.parseInt(date_MDY_values[2]);
			
			// Get the current date
			long currentDate = System.currentTimeMillis();
			
			// Calculate the number of days between the two dates
			long daysSinceDate = calculateDaysBetween(day, month, year, currentDate);
			
			// Display the result
			System.out.printf("It has been %d days since %s", daysSinceDate, inputDate);
		} catch (Exception e) {
			System.out.println("Invalid date format. Please enter a date in the format MM dd yyyy.");
		}
	}
	
	private static long calculateDaysBetween(int day, int month, int year, long currentDate) {
		//number of days in the entered year
		long daysInYear = year * 365 + countLeapYears(year);
		
		//number of days in the entered month
		long daysInMonth = getDaysInMonth(month, year);
		
		//number of days in the entered day
		long daysInDay = day - 1;
		
		//difference between the entered date and the current date
		return (currentDate / (24 * 60 * 60 * 1000)) - (daysInYear + daysInMonth + daysInDay);
	}
	
	private static long countLeapYears(int year) {
		//number of leap years from 0000 to (year - 1)
		return year / 4 - year / 100 + year / 400;
	}
	
	private static long getDaysInMonth(int month, int year) {
		//each month has different numbers of days on them. this array includes that as a variable too
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeapYear(year)) {
			daysInMonth[1] = 29; // February has 29 days in a leap year
		}
		long days = 0;
		for (int i = 0; i < month - 1; i++) {
			days += daysInMonth[i];
		}
		return days;
	}
	
	private static boolean isLeapYear(int year) {
		//if the year is divisible by 4 but not by 100, or if it is divisible by 400, its leap year
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
/*used this website to make sure the result is correct each time i checked if program is working well:
* https://www.timeanddate.com/date/duration.html
* */
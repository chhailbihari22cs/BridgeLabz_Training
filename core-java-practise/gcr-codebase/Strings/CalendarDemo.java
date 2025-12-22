import java.util.*;

public class CalendarDemo {

    // Method to get month name
    static String getMonthName(int m) {
        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        return months[m - 1];
    }

    // Method to check leap year
    static boolean isLeapYear(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }

    // Method to get number of days in month
    static int getDays(int m, int y) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (m == 2 && isLeapYear(y))
            return 29;
        return days[m - 1];
    }

    // Method to get first day of month using Gregorian algorithm
    static int getFirstDay(int d, int m, int y) {
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; // 0=Sunday, 1=Monday, ...
    }

    // Method to display calendar
    static void displayCalendar(int m, int y) {
        System.out.println("\n   " + getMonthName(m) + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int days = getDays(m, y);
        int startDay = getFirstDay(1, m, y);

        // First loop for indentation
        for (int i = 0; i < startDay; i++)
            System.out.print("    ");

        // Second loop for days
        for (int d = 1; d <= days; d++) {
            System.out.printf("%3d ", d);
            if (((d + startDay) % 7 == 0))
                System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        System.out.print("Enter year: ");
        int y = sc.nextInt();

        displayCalendar(m, y);
    }
}

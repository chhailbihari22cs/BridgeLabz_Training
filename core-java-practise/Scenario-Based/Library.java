import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalFine = 0;

    
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nBook " + i + ":");

            
            System.out.print("due date (yyyy-mm-dd): ");
            String dueDateStr = sc.nextLine();
            LocalDate dueDate = LocalDate.parse(dueDateStr);

           
            System.out.print("return date (yyyy-mm-dd): ");
            String returnDateStr = sc.nextLine();
            LocalDate returnDate = LocalDate.parse(returnDateStr);

          
            int fine = 0;
            if (returnDate.isAfter(dueDate)) {
                long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
                fine = (int) daysLate * 5;
            }

            System.out.println("Fine for Book " + i + fine);
            totalFine += fine;
        }

        System.out.println("\nTotal Fine for all books" + totalFine);
        sc.close();
    }
}

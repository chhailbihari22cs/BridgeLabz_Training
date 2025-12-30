import java.util.Random;

/**
 * Representing a real-world Employee with their own pay structure and logic.
 */
class Employee {
    // We use 'private final' to protect data that shouldn't change randomly
    private final String name;
    private final int wagePerHour;
    private final int maxDays;
    private final int maxHours;

    public Employee(String name, int wagePerHour, int maxDays, int maxHours) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.maxDays = maxDays;
        this.maxHours = maxHours;
    }

    public void calculateMonthlyWage() {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;
        Random random = new Random();

        System.out.println("--- Generating Payroll for: " + name + " ---");

        // The "While" loop handles the logic of reaching limits
        while (totalDays < maxDays && totalHours < maxHours) {
            totalDays++;

            // Human-readable attendance check
            int workType = random.nextInt(3); // 0: Absent, 1: Full, 2: Part-time
            int hoursToday = getWorkHours(workType);

            // Logic to cap hours so we don't exceed the monthly max
            if (totalHours + hoursToday > maxHours) {
                hoursToday = maxHours - totalHours;
            }

            totalHours += hoursToday;
            int dailyWage = hoursToday * wagePerHour;
            totalWage += dailyWage;

            if (hoursToday > 0) {
                System.out.printf("Day %d: Worked %d hrs. Earned $%d%n", totalDays, hoursToday, dailyWage);
            } else {
                System.out.printf("Day %d: Absent%n", totalDays);
            }
        }

        displaySummary(totalDays, totalHours, totalWage);
    }

    private int getWorkHours(int type) {
        return switch (type) {
            case 1 -> 8; // Full Day
            case 2 -> 4; // Part-Time
            default -> 0; // Absent
        };
    }

    private void displaySummary(int days, int hours, int wage) {
        System.out.println("\n--- Final Monthly Summary ---");
        System.out.println("Employee Name:  " + name);
        System.out.println("Days Worked:    " + days);
        System.out.println("Total Hours:    " + hours);
        System.out.println("Total Salary:   $" + wage);
        System.out.println("-----------------------------\n");
    }
}

public class WageSystem {
    public static void main(String[] args) {
        // Now it's easy to create different employees with different rates
        Employee emp1 = new Employee("John Doe", 20, 20, 100);

        emp1.calculateMonthlyWage();
    }
}
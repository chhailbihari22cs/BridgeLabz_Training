import java.util.Random;

public class ZaraBonusCalculator {

    // Method to generate salary and years of service for 10 employees
    public static double[][] generateEmployeeData(int employees) {
        double[][] data = new double[employees][2]; // [salary, yearsOfService]
        Random rand = new Random();

        for (int i = 0; i < employees; i++) {

            double salary = 10000 + rand.nextInt(90000);
            // Generate years of service between 1 and 15
            double years = 1 + rand.nextInt(15);

            data[i][0] = salary;
            data[i][1] = years;
        }
        return data;
    }

    public static double calculateBonus(double salary, double years) {
        if (years > 5) {
            return salary * 0.05; // 5% bonus
        } else {
            return salary * 0.02; // 2% bonus
        }
    }

    public static void main(String[] args) {
        int employees = 10;
        double[][] employeeData = generateEmployeeData(employees);

        double totalBonus = 0;

        System.out.println("Zara Employee Bonus Report:");
        System.out.println("-------------------------------------------------------------");
        System.out.println("EmpID\tSalary\tYears\tBonus\tNew Salary");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < employees; i++) {
            double salary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonus = calculateBonus(salary, years);
            double newSalary = salary + bonus;

            totalBonus += bonus;

            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f\n",
                    (i + 1), salary, years, bonus, newSalary);
        }

        System.out.println("------------------");
        System.out.printf("Total Bonus Zara has to pay: %.2f\n", totalBonus);
    }
}

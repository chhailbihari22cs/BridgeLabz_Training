import java.util.Scanner;

public class TriangularParkRun {
    public static double calculateRounds(double side1, double side2, double side3, double distance) {
        double perimeter = side1 + side2 + side3;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side1 (m): ");
        double s1 = sc.nextDouble();
        System.out.print("Enter side2 (m): ");
        double s2 = sc.nextDouble();
        System.out.print("Enter side3 (m): ");
        double s3 = sc.nextDouble();

        double rounds = calculateRounds(s1, s2, s3, 5000); // 5 km = 5000 m
        System.out.println("The athlete must complete " + Math.ceil(rounds) + " rounds.");
    }
}

import java.util.Scanner;

public class Bus_Root_Tracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalDistance = 0;
        int stopNumber = 1;

        System.out.println(" BUS ROUTE DISTANCE TRACKER ");
        System.out.println("Welcome To Our Bus\n");

        while (true) {
            System.out.println("Stop " + stopNumber + " reached!");
            System.out.print("Enter distance to this stop  ");
            double distance = sc.nextDouble();

            totalDistance = totalDistance + distance;
            System.out.println("Total distance traveled: " + totalDistance + " km");

            System.out.print("Do you want to get off at this stop? (yes/no): ");
            String response = sc.next().toLowerCase();

            if (response.equals("yes")) {
                System.out.println("\n JOURNEY COMPLETED ");
                System.out.println("You traveled total " + totalDistance + " km");
                System.out.println("Total stops: " + stopNumber);
                System.out.println("Thank you and Visit Again!");
                break;
            } else {
                System.out.println("On the Way to next Destinatoin...\n");
                stopNumber++;
            }
        }
    }
}
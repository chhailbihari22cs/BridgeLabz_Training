import java.util.Scanner;

class BusRoute {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalDistance = 0;
        char getOff = 'n';

        while (getOff != 'y') {

            System.out.println("Enter distance for next stop (in km):");
            int distance = sc.nextInt();

            if (distance <= 0) {
                System.out.println("Invalid distance");
                continue;
            }

            totalDistance = totalDistance + distance;

            System.out.println("Total distance covered: " + totalDistance + " km");

            System.out.println("Do you want to get off? (y/n)");
            getOff = sc.next().charAt(0);
        }

        System.out.println("Journey ended.");
        System.out.println("Final distance: " + totalDistance + " km");

        sc.close();
    }
}

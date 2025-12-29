import java.util.Scanner;

class MovieApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice = 'y';

        while (choice == 'y') {

            int price = 0;

            System.out.println("Movie type:");
            System.out.println("1 Action");
            System.out.println("2 Comedy");
            System.out.println("3 Drama");
            int movie = sc.nextInt();

            switch (movie) {
                case 1:
                    price = 200;
                    break;
                case 2:
                    price = 180;
                    break;
                case 3:
                    price = 150;
                    break;
                default:
                    System.out.println("Wrong choice");
                    continue;
            }

            System.out.println("Seat type (gold/silver):");
            String seat = sc.next();

            if (seat.equals("gold")) {
                price = price + 100;
            } else if (seat.equals("silver")) {
                price = price + 50;
            } else {
                System.out.println("Seat not available");
                continue;
            }

            System.out.println("Snacks chahiye? (yes/no)");
            String snacks = sc.next();

            if (snacks.equals("yes")) {
                price = price + 80;
            }

            System.out.println("Total bill: " + price);

            System.out.println("Next customer? (y/n)");
            choice = sc.next().charAt(0);
        }

        sc.close();
    }
}

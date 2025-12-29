import java.util.Scanner;

class SandeepFitnessTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] pushUps = new int[7];

        System.out.println("Enter push-ups for 7 days:");

        for (int i = 0; i < 7; i++) {
            pushUps[i] = sc.nextInt();
        }

        int total = 0;
        int days = 0;

        for (int count : pushUps) {

            if (count == 0) {
                continue;
            }

            total = total + count;
            days++;
        }

        int average = total / days;

        System.out.println("Total push-ups: " + total);
        System.out.println("Average push-ups: " + average);

        sc.close();
    }
}

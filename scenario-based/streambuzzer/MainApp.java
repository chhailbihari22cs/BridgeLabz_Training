package StreamBuzz;

import java.util.*;

public class MainApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        EngagementBoard board = new EngagementBoard();

        while (true) {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Get Top Post Counts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] likes = new double[4];
                    System.out.println("Enter Weekly Likes for 4 weeks:");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }

                    board.registerCreator(new CreatorStats(name, likes));
                    break;

                case 2:
                    System.out.print("Enter like threshold: ");
                    double threshold = sc.nextDouble();

                    Map<String, Integer> topCreators =
                            board.getTopPostCounts(threshold);

                    if (topCreators.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> e : topCreators.entrySet()) {
                            System.out.println(
                                e.getKey() + " - " + e.getValue() + " weeks"
                            );
                        }
                    }
                    break;

                case 3:
                    double avg = board.calculateOverallAverageLikes();
                    System.out.println(
                        "Overall average weekly likes: " + avg
                    );
                    break;

                case 4:
                    System.out.println(
                        "Logging off — Keep Creating with StreamBuzz!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }

	}

}
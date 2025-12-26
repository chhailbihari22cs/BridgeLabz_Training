import java.util.*;

public class RPSGame {

    // Method to get computer choice
    static String compChoice() {
        int n = (int) (Math.random() * 3); // 0,1,2
        if (n == 0)
            return "rock";
        else if (n == 1)
            return "paper";
        else
            return "scissors";
    }

    // Method to decide winner
    static String findWinner(String user, String comp) {
        if (user.equals(comp))
            return "Draw";
        if (user.equals("rock") && comp.equals("scissors"))
            return "User";
        if (user.equals("scissors") && comp.equals("paper"))
            return "User";
        if (user.equals("paper") && comp.equals("rock"))
            return "User";
        return "Computer";
    }

    // Method to calculate stats
    static String[][] calcStats(int userWins, int compWins, int total) {
        String[][] stats = new String[2][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf((userWins * 100.0) / total) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.valueOf((compWins * 100.0) / total) + "%";

        return stats;
    }

    // Method to display results
    static void displayResults(List<String[]> games, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");
        int g = 1;
        for (String[] row : games) {
            System.out.println(g + "\t" + row[0] + "\t" + row[1] + "\t\t" + row[2]);
            g++;
        }

        System.out.println("\nFinal Stats:");
        System.out.println("Player\tWins\tWin%");
        for (String[] row : stats) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();

        int userWins = 0, compWins = 0;
        List<String[]> games = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.next().toLowerCase();
            String comp = compChoice();
            String winner = findWinner(user, comp);

            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                compWins++;

            games.add(new String[] { user, comp, winner });
        }

        String[][] stats = calcStats(userWins, compWins, n);
        displayResults(games, stats);
    }
}

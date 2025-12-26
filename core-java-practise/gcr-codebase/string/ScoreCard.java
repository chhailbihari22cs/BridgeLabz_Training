import java.util.*;

public class ScoreCard {

    // a. Generate random PCM scores for n students
    static int[][] genScores(int n) {
        Random r = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = 40 + r.nextInt(60); // Physics
            scores[i][1] = 40 + r.nextInt(60); // Chemistry
            scores[i][2] = 40 + r.nextInt(60); // Math
        }
        return scores;
    }

    // b. Calculate total, average, percentage
    static String[][] calcStats(int[][] scores) {
        String[][] stats = new String[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            stats[i][0] = String.valueOf(total);
            stats[i][1] = String.valueOf(Math.round(avg * 100.0) / 100.0);
            stats[i][2] = String.valueOf(Math.round(perc * 100.0) / 100.0);
        }
        return stats;
    }

    // c. Assign grade based on percentage
    static String[] assignGrade(String[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double perc = Double.parseDouble(stats[i][2]);
            if (perc >= 80)
                grades[i] = "A";
            else if (perc >= 70)
                grades[i] = "B";
            else if (perc >= 60)
                grades[i] = "C";
            else if (perc >= 50)
                grades[i] = "D";
            else if (perc >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }
        return grades;
    }

    // d. Display full scorecard
    static void display(int[][] scores, String[][] stats, String[] grades) {
        System.out.println("\nScorecard:");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPerc\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" +
                    stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = genScores(n);
        String[][] stats = calcStats(scores);
        String[] grades = assignGrade(stats);
        display(scores, stats, grades);
    }
}

import java.util.*;

public class VoteDemo {
    // Generate random ages for n students
    static int[] genAge(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = 10 + r.nextInt(90); // random age between 10–99
        return arr;
    }

    // Check voting eligibility
    static String[][] checkVote(int[] arr) {
        String[][] res = new String[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            res[i][0] = String.valueOf(arr[i]); // store age
            if (arr[i] < 0)
                res[i][1] = "false"; // invalid age
            else if (arr[i] >= 18)
                res[i][1] = "true"; // eligible
            else
                res[i][1] = "false"; // not eligible
        }
        return res;
    }

    // Display results in tabular format
    static void display(String[][] arr) {
        System.out.println("Age\tCanVote");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t" + arr[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = genAge(n); // generate ages
        String[][] res = checkVote(ages); // check eligibility
        display(res); // display results
    }
}

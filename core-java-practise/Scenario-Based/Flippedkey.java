import java.util.Scanner;

public class Flippedkey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the word");
        String input = scanner.nextLine();

        String result = CleanseAndInvert(input);

        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Flipped key: " + result);
        }

        scanner.close();
    }

    public static String CleanseAndInvert(String input) {

        if (input == null || input.length() < 6) {
            return "";
        }

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c) || Character.isDigit(c) || !Character.isLetter(c)) {
                return "";
            }
        }

        input = input.toLowerCase();

        StringBuilder filtered = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c % 2 != 0) {
                filtered.append(c);
            }
        }

        String reversed = filtered.reverse().toString();

        char[] resultArray = reversed.toCharArray();
        for (int i = 0; i < resultArray.length; i++) {
            if (i % 2 == 0) {
                resultArray[i] = Character.toUpperCase(resultArray[i]);
            }
        }

        return new String(resultArray);
    }
}
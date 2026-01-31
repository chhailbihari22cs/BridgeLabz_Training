import java.util.*;

public class LexicalTwist {

    // Method to check if a word is valid (single word only)
    private static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

    // Method to check if second word is reverse of first (case-insensitive)
    private static boolean isReverse(String first, String second) {
        String reversed = new StringBuilder(first).reverse().toString();
        return reversed.equalsIgnoreCase(second);
    }

    // Method to replace vowels with '@'
    private static String replaceVowels(String word) {
        return word.replaceAll("[aeiou]", "@");
    }

    // Method to count vowels
    private static int countVowels(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if ("AEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to count consonants
    private static int countConsonants(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z' && "AEIOU".indexOf(c) == -1) {
                count++;
            }
        }
        return count;
    }

    // Method to get first two unique characters from a set
    private static String getFirstTwoUnique(String word, String type) {
        Set<Character> set = new LinkedHashSet<>();

        for (char c : word.toCharArray()) {
            if (type.equals("VOWEL") && "AEIOU".indexOf(c) != -1) {
                set.add(c);
            } else if (type.equals("CONSONANT") && "AEIOU".indexOf(c) == -1) {
                set.add(c);
            }
            if (set.size() == 2) break;
        }

        StringBuilder result = new StringBuilder();
        for (char c : set) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        if (!isValidWord(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (!isValidWord(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }

        // Case 1: Second word is reverse of first
        if (isReverse(first, second)) {
            String reversed = new StringBuilder(first).reverse().toString().toLowerCase();
            String transformed = replaceVowels(reversed);
            System.out.println(transformed);
        }
        // Case 2: Not a reverse
        else {
            String combined = (first + second).toUpperCase();

            int vowels = countVowels(combined);
            int consonants = countConsonants(combined);

            if (vowels > consonants) {
                System.out.println(getFirstTwoUnique(combined, "VOWEL"));
            } else if (consonants > vowels) {
                System.out.println(getFirstTwoUnique(combined, "CONSONANT"));
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        sc.close();
    }
}

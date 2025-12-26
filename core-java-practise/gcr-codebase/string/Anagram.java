import java.util.*;

public class Anagram {
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] f1 = new int[256], f2 = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i)]++;
            f2[s2.charAt(i)]++;
        }
        return Arrays.equals(f1, f2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println("Are Anagrams: " + isAnagram(s1, s2));
    }
}

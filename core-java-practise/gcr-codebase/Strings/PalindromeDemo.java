import java.util.*;

public class PalindromeDemo {

    static boolean isPalindromeIter(String s) {
        int st = 0, en = s.length() - 1;
        while (st < en) {
            if (s.charAt(st) != s.charAt(en))
                return false;
            st++;
            en--;
        }
        return true;
    }

    static boolean isPalindromeRec(String s, int st, int en) {
        if (st >= en)
            return true;
        if (s.charAt(st) != s.charAt(en))
            return false;
        return isPalindromeRec(s, st + 1, en - 1);
    }

    static boolean isPalindromeArr(String s) {
        char[] arr = s.toCharArray();
        char[] rev = new char[arr.length];
        for (int i = 0; i < arr.length; i++)
            rev[i] = s.charAt(arr.length - 1 - i);
        return Arrays.equals(arr, rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Iterative: " + isPalindromeIter(s));
        System.out.println("Recursive: " + isPalindromeRec(s, 0, s.length() - 1));
        System.out.println("Array method: " + isPalindromeArr(s));
    }
}

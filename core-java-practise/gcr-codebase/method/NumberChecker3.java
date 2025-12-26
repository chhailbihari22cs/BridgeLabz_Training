import java.util.Arrays;

public class NumberChecker3 {

    public static int[] getDigits(int num) {
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = s.charAt(i) - '0';
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            rev[i] = arr[arr.length - 1 - i];
        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int num) {
        int[] digits = getDigits(num);
        return arraysEqual(digits, reverseArray(digits));
    }

    public static boolean isDuck(int num) {
        int[] digits = getDigits(num);
        for (int d : digits)
            if (d == 0)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int num = 707;
        System.out.println("Palindrome: " + isPalindrome(num));
        System.out.println("Duck number: " + isDuck(num));
    }
}
